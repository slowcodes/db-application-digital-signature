package ng.com.bitsystems.digitalsignature.controllers;

import lombok.extern.slf4j.Slf4j;
import ng.com.bitsystems.digitalsignature.command.*;
import ng.com.bitsystems.digitalsignature.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

@Slf4j
@Controller
public class ResultController {

    private CoursesServices coursesServices;
    private ResultsService resultsService;
    private SessionService sessionService;
    private DepartmentService departmentService;
    private UploadService uploadService;
    private StudentsService studentsService;
    private PrivateKeyService privateKeyService;
    private UsersService usersService;

    public ResultController(CoursesServices coursesServices,
                            PrivateKeyService privateKeyService,
                            UsersService usersService,
                            ResultsService resultsService,
                            SessionService sessionService,
                            DepartmentService departmentService,
                            UploadService uploadService,
                            StudentsService studentsService) {
        this.coursesServices = coursesServices;
        this.resultsService = resultsService;
        this.sessionService = sessionService;
        this.departmentService = departmentService;
        this.uploadService = uploadService;
        this.studentsService = studentsService;
        this.privateKeyService = privateKeyService;
        this.usersService = usersService;
    }

    @RequestMapping({"/results/upload/"})
    public String upload(Model model){
        model.addAttribute("upload", new UploadCommand());
        model.addAttribute("sessions", sessionService.findAll());
        model.addAttribute("courses", coursesServices.findAll());
        model.addAttribute("keys", privateKeyService.findAll());
        return "pages/upload.html";
    }

    @RequestMapping({"results/{id}/view"})
    public String studentResult(@PathVariable String id, Model model){
        //results = studentsService.findByID(new Long(id)).getResults(); //resultsService.getStudentResultById(new Long(id));
        model.addAttribute("results", studentsService.findByID(new Long(id)));
        return "pages/studentresults.html";
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

                CoursesCommand coursesCommand = coursesServices.getCourseCommandById(uploadCommand.getCoursesCommand().getId());
                SessionCommand sessionCommand = sessionService.getSessionCommandById(uploadCommand.getSessionCommand().getId());

                uploadCommand.setCoursesCommand(coursesCommand);
                uploadCommand.setSessionCommand(sessionCommand);
                uploadCommand.setDateOfUpload(LocalDate.now());
                uploadCommand.setUsersCommand(usersService.findCommandById(new Long(1)));
                uploadCommand.setPrivateKeyCommand(privateKeyService.findCommandByID(uploadCommand.getPrivateKeyCommand().getId()));
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
                    if(studentsService.getCommandByMatricNumber(matricNumber) != null){

                        ResultCommand resultCommand = new ResultCommand();

                        resultCommand.setTestScore(Double.parseDouble(values[2]));
                        resultCommand.setExamScore(Double.parseDouble(values[3]));
                        resultCommand.setStudentCommand(studentCommand);
                        resultCommand.setUploadId(command.getId());
                        //studentCommand.getResultCommands().add(resultCommand);
                        //studentsService.addCommand(studentCommand);
                        resultsService.addResultCommand(resultCommand);
                        command.getResultCommand().add(resultCommand);
                        log.info("Valid Registration # "+matricNumber);
                    }
                    else {
                        //invalid  student
                        log.info("Invalid Registration #"+matricNumber);
                    }
                }
                //cosmilla hotel
                br.close();
                model.addAttribute("message", "Result has been successfully uploaded. A student's result can be accessed by clicking on the view results link");
            }
            catch (IOException e){
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
            catch (NullPointerException e){
                model.addAttribute("message", "Invalid student number.");
                model.addAttribute("status", false);
                log.info("Null pointer exception caught # ");
                e.printStackTrace();
            }

        }
        model.addAttribute("upload", new UploadCommand());
        //model.addAttribute("message", "Result has been suceesfully uploaded. A student's result can be accessed by clicking on the view results link");
        return "pages/uploadresult.html";
    }
}
