package ng.com.bitsystems.digitalsignature.controllers;

import ng.com.bitsystems.digitalsignature.command.PrivateKeyCommand;
import ng.com.bitsystems.digitalsignature.command.PublicKeyCommand;
import ng.com.bitsystems.digitalsignature.services.PrivateKeyService;
import ng.com.bitsystems.digitalsignature.services.PublicKeysService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class KeyController {

    private PrivateKeyService privateKeyService;
    private PublicKeysService publicKeysService;

    public KeyController(PrivateKeyService privateKeyService, PublicKeysService publicKeysService){
        this.privateKeyService = privateKeyService;
        this.publicKeysService = publicKeysService;
    }

    @RequestMapping("/keys/")
    public String publickeys(Model model){
        //model.addAttribute("pKey", new PrivateKeyCommand());
        model.addAttribute("pKey", new PublicKeyCommand());
        model.addAttribute("keys", privateKeyService.findAll());
        return "pages/key.html";
    }

    @RequestMapping("/addkey")
    public String addPrivateKey(@ModelAttribute PublicKeyCommand publicKeyCommand){
        publicKeyCommand.getPrivateKeyCommand().setCreatedAt(LocalDate.now());
        PrivateKeyCommand privateKeyCommand1 = privateKeyService.add(publicKeyCommand.getPrivateKeyCommand());
        publicKeyCommand.setPrivateKeyCommand(privateKeyCommand1);
        PublicKeyCommand publicKeyCommand1 = publicKeysService.add(publicKeyCommand);
        return "pages/view.html";
    }

}
