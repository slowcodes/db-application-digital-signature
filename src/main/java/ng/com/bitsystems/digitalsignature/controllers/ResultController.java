package ng.com.bitsystems.digitalsignature.controllers;

import lombok.extern.slf4j.Slf4j;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.command.UploadCommand;
import ng.com.bitsystems.digitalsignature.converters.SessionCommandToSession;
import ng.com.bitsystems.digitalsignature.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Slf4j
@Controller
public class ResultController {

    private SessionCommandToSession sessionCommandToSession;
    private ResultsService resultsService;
    private SessionService sessionService;
    private DepartmentService departmentService;
    private UploadService uploadService;
    private StudentsService studentsService;

    public ResultController(SessionCommandToSession sessionCommandToSession,
                            ResultsService resultsService, SessionService sessionService,
                            DepartmentService departmentService,
                            UploadService uploadService,
                            StudentsService studentsService) {
        this.sessionCommandToSession = sessionCommandToSession;
        this.resultsService = resultsService;
        this.sessionService = sessionService;
        this.departmentService = departmentService;
        this.uploadService = uploadService;
    }

    @RequestMapping({"/result/upload/"})
    public String upload(Model model){
        model.addAttribute("upload", new UploadCommand());
        model.addAttribute("sessions", sessionService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        return "pages/upload.html";
    }

    @PostMapping("/result/process_upload/")
    public String uploadResult(@ModelAttribute UploadCommand uploadCommand,
            @RequestParam("file") MultipartFile file, Model model){

        if (file.isEmpty()){
            model.addAttribute("message", "please select a .csv file");
            model.addAttribute("status", false);
        }
        else {

            try{
                UploadCommand command = uploadService.addUploadCommand(uploadCommand);
                byte[] bytes = file.getBytes();
                ByteArrayInputStream inputFilestream = new ByteArrayInputStream(bytes);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputFilestream ));
                String line = "";
                while ((line = br.readLine()) != null) {
                    System.out.println(line);

                    String[] values= line.split(",");
                    String matricNumber = values[0];
                    StudentCommand studentCommand = studentsService.getCommandByMatricNumber(matricNumber);

                    if(studentCommand != null){
                        ResultCommand resultCommand = new ResultCommand();
                        resultCommand.setTestScore(Double.parseDouble(values[1]));
                        resultCommand.setExamScore(Double.parseDouble(values[2]));
                        resultCommand.setStudentId(studentCommand.getId());
                        resultCommand.setUploadCommand(uploadCommand);
                        resultsService.addResultCommand(resultCommand);
                    }
                    else {
                        //invalid  student
                    }


                }
                br.close();
            }
            catch (IOException e){
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }


            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//
//                // create csv bean reader
//                CsvToBean<ResultWrapper> csvToBean = new CsvToBeanBuilder(reader)
//                        .withType(ResultWrapper.class)
//                        .withIgnoreLeadingWhiteSpace(true)
//                        .build();
//
//
//                // convert `CsvToBean` object to list of users
//                List<ResultWrapper> resultCommands = csvToBean.parse();
//                resultCommands.forEach(result -> {
//                    //result.setSession(sessionCommandToSession.convert(sessionCommand));
//                    log.error(result.getRegNo());
//                    //resultsService.add(result);
//                });

                // TODO: save users in DB?

                // save users list on model
//                model.addAttribute("results", resultCommands);
//                model.addAttribute("status", true);
            }
            catch (IOException e){
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }
        model.addAttribute("upload", new UploadCommand());
        return "pages/upload.html";
    }
}
