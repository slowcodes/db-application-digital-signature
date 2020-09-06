package ng.com.bitsystems.digitalsignature.controllers;

import ng.com.bitsystems.digitalsignature.command.UploadCommand;
import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.services.StudentsService;
import ng.com.bitsystems.digitalsignature.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    private UsersService usersService;
    private StudentsService studentsService;

    public DashboardController(UsersService usersService, StudentsService studentsService) {
        this.studentsService = studentsService;
        this.usersService = usersService;
    }

    @RequestMapping({"/dashboard", "dashboard.html", "dashboard/index.html"})
    public String dashboard(@ModelAttribute UsersCommand userscommand, Model model){

        UsersCommand usersCommand = usersService.findUserCommand(userscommand);
        return "pages/index.html";
    }

    @RequestMapping({"/dashboard/enter/"})
    public String addresult(Model model){
        model.addAttribute("model", new UploadCommand());
        return "pages/enter.html";
    }



    @RequestMapping("/dashboard/transcript/")
    public String privatekeys(Model model){
        return "pages/layout-static.html";
    }

    @RequestMapping({"/dashboard/results/"})
    public String getResutlts(Model model){
        return "pages/classresults.html";
    }

    @RequestMapping("/dashboard/mycourses/")
    public String mycourses(Model model){
        return "pages/transcript.html";
    }

    @RequestMapping({"/dashboard/viewresults/"})
    public String students(Model model){
        model.addAttribute("students", studentsService.findAll());
        return "pages/viewresult.html";
    }

}
