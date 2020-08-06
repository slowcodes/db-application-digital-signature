package ng.com.bitsystems.digitalsignature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping({"/dashboard", "dashboard.html", "dashboard/index.html"})
    public String dashboard(Model model){
        //return "pages/index.html";
        return "pages/layout-sidenav-light.html";
    }

    @RequestMapping({"/dashboard/upload/"})
    public String upload(Model model){
        return "pages/upload.html";
    }

    @RequestMapping("/dashboard/keys/")
    public String publickeys(Model model){
        return "pages/register.html";
    }

    @RequestMapping("/dashboard/transcript/")
    public String privatekeys(Model model){
        return "pages/layout-static.html";
    }

    @RequestMapping({"/dashboard/myuploads/"})
    public String getResutlts(Model model){
        return "pages/layout-sidenav-light.html";
    }

    @RequestMapping("/dashboard/mycourses/")
    public String mycourses(Model model){
        return "pages/chart.html";
    }

    @RequestMapping("/dashboard/students/mycourses/")
    public String students(Model model){
        return "pages/chart.html";
    }
}
