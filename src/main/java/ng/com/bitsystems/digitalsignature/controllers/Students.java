package ng.com.bitsystems.digitalsignature.controllers;

import ng.com.bitsystems.digitalsignature.command.StudentCommand;
import ng.com.bitsystems.digitalsignature.converters.ResultsToResultsCommand;
import ng.com.bitsystems.digitalsignature.services.CipherService;
import ng.com.bitsystems.digitalsignature.services.StudentsService;
import ng.com.bitsystems.digitalsignature.services.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Students {

    private StudentsService studentsService;
    private UploadService uploadService;
    private ResultsToResultsCommand resultsToResultsCommand;
    private CipherService cipherService;

    public Students(StudentsService studentsService,
                    UploadService uploadService,
                    ResultsToResultsCommand resultsToResultsCommand,
                    CipherService cipherService) {
        this.studentsService = studentsService;
        this.uploadService = uploadService;
        this.resultsToResultsCommand = resultsToResultsCommand;
        this.cipherService = cipherService;
    }

    @RequestMapping("/students")
    public String list(Model model){
        model.addAttribute("students", studentsService.findAll());
        return "pages/students";
    }

    @RequestMapping("/checker")
    public String checkresult(Model model){
        model.addAttribute("student", new StudentCommand());
        return "pages/login/security/checker";
    }

//    @RequestMapping("/results")
//    public String getResult(Model model, @ModelAttribute StudentCommand studentCommand){
//
//        try{
//            StudentCommand studentComm = studentsService.getCommandByMatricNumber(studentCommand.getMatricNumber().trim());
//            Set<ResultCommand> resultCommands = new HashSet<>();
//            Set<Results> results  =studentsService.findByID(studentComm.getId()).getResults();
//            model.addAttribute("student", studentsService.findByID(studentComm.getId()));
//
//            double cumulative = 0;
//            double totalUnit = 0;
//
//            for (Results result: results){
//                PrivateKeys signingKey = uploadService.findByID(result.getUpload().getId()).getPrivateKeys();
//
//                double point = 0;
//                ResultCommand resultCommand = resultsToResultsCommand.convert(result);
//                resultCommand.setCourseTitle(result.getUpload().getCourse().getCourseTitle());
//                resultCommand.setCourseCode(result.getUpload().getCourse().getCourseCode());
//
//                double exam = Double.parseDouble(cipherService.decrypt(resultCommand.getExamScore(),signingKey.getPrivateKey()));
//                double test = Double.parseDouble(cipherService.decrypt(resultCommand.getTestScore(),signingKey.getPrivateKey()));
//
//                resultCommand.setExamScore(cipherService.decrypt(resultCommand.getExamScore(),signingKey.getPrivateKey()));
//                resultCommand.setTestScore(cipherService.decrypt(resultCommand.getTestScore(),signingKey.getPrivateKey()));
//
//                double total = test + exam;
//                resultCommand.setTotal(total);
//                if(total >= 70) {
//                    resultCommand.setGrade("A");
//                    point = 5;
//                }
//                else if (total >= 60){
//                    resultCommand.setGrade("B");
//                    point = 4;
//                }
//                else if (total >= 50){
//                    resultCommand.setGrade("C");
//                    point = 3;
//                }
//                else if (total >= 45){
//                    resultCommand.setGrade("D");
//                    point = 2;
//                }
//                else if (total >= 40){
//                    resultCommand.setGrade("E");
//                    point = 1;
//                }
//                else {
//                    resultCommand.setGrade("F");
//                    point = 0;
//                }
//                resultCommands.add(resultCommand);
//                totalUnit += result.getUpload().getCourse().getCredits();
//                cumulative += point * result.getUpload().getCourse().getCredits();
//            }
//            double cgpa = cumulative/totalUnit;
//
//            model.addAttribute("cgpa", cgpa);
//            model.addAttribute("results", resultCommands);
//
//            return "pages/myresultpage";
//        }
//        catch (NullPointerException e){
//            e.printStackTrace();
//            model.addAttribute("message","Invalid student registration number");
//            model.addAttribute("student", new StudentCommand());
//            return "pages/login/security/checker";
//        }
//
//    }
}
