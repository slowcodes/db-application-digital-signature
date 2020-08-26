package ng.com.bitsystems.digitalsignature.controllers;

import ng.com.bitsystems.digitalsignature.command.UsersCommand;
import ng.com.bitsystems.digitalsignature.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping({"/users"})
    public String userForm(Model model){
        model.addAttribute("users", new UsersCommand());
        //UsersCommand usersCommand = usersService.
        return "pages/register";
    }

    @RequestMapping({"/adduser"})
    public String addUser(@ModelAttribute UsersCommand userCommand){
        UsersCommand usersCommand = usersService.addUserCommand(userCommand);
        return "redirect:/";
    }
}
