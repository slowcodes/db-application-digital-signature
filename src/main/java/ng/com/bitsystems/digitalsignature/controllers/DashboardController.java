package ng.com.bitsystems.digitalsignature.controllers;

import ng.com.bitsystems.digitalsignature.command.UploadCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping({"/dashboard", "dashboard.html", "dashboard/index.html"})
    public String dashboard(Model model){
        return "pages/index.html";
    }

    @RequestMapping({"/dashboard/enter/"})
    public String addresult(Model model){
        model.addAttribute("model", new UploadCommand());
        return "pages/enter.html";
    }

    @RequestMapping("/dashboard/keys/")
    public String publickeys(Model model){
        return "pages/key.html";
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

    @RequestMapping("/dashboard/viewresults/")
    public String students(Model model){
        return "pages/view.html";
    }
}
