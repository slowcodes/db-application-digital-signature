package ng.com.bitsystems.digitalsignature.controllers;

import ng.com.bitsystems.digitalsignature.command.PrivateKeyCommand;
import ng.com.bitsystems.digitalsignature.services.PrivateKeyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class KeyController {

    private PrivateKeyService privateKeyService;

    public KeyController(PrivateKeyService privateKeyService){
        this.privateKeyService = privateKeyService;
    }

    @RequestMapping("/keys/")
    public String publickeys(Model model){
        model.addAttribute("pKey", new PrivateKeyCommand());
        model.addAttribute("keys", privateKeyService.findAll());
        return "pages/key.html";
    }

    @RequestMapping("/addkey")
    public String addPrivateKey(@ModelAttribute PrivateKeyCommand privateKeyCommand){
        privateKeyCommand.setCreatedAt(LocalDate.now());
        PrivateKeyCommand privateKeyCommand1 = privateKeyService.add(privateKeyCommand);
        return "pages/view.html";
    }

}
