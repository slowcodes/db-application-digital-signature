package ng.com.bitsystems.digitalsignature.controllers;

import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"index","/","index.html"})
    public String home(Model model){
        model.addAttribute("");
        model.addAttribute("user", new UsersCommand());
        return "pages/login/security/index.html";
    }

//    @RequestMapping("register")
//    public String register(Model model){
//
//        //return "pages/register.html";
//    }
}
