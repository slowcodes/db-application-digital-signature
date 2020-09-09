package ng.com.bitsystems.digitalsignature.controllers;

import lombok.extern.slf4j.Slf4j;
import ng.com.bitsystems.digitalsignature.command.PrivateKeyCommand;
import ng.com.bitsystems.digitalsignature.services.PrivateKeyService;
import ng.com.bitsystems.digitalsignature.services.PublicKeysService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@Slf4j
public class KeyController {

    private PrivateKeyService privateKeyService;
    private PublicKeysService publicKeysService;

    public KeyController(PrivateKeyService privateKeyService, PublicKeysService publicKeysService){
        this.privateKeyService = privateKeyService;
        this.publicKeysService = publicKeysService;
    }

    @RequestMapping("/keys")
    public String publickeys(Model model){
        //model.addAttribute("pKey", new PrivateKeyCommand());
        model.addAttribute("pKey", new PrivateKeyCommand());
        model.addAttribute("keys", privateKeyService.findAll());
        return "pages/key.html";
    }

    @RequestMapping("/addkey")
    public String addPrivateKey(@ModelAttribute PrivateKeyCommand privateKeyCommand, Model model){
        privateKeyCommand.setCreatedAt(LocalDate.now());
//        PrivateKeyCommand privateKeyCommand1 = privateKeyService.add(publicKeyCommand.getPrivateKeyCommand());
//        publicKeyCommand.setPrivateKeyCommand(privateKeyCommand1);
//        PublicKeyCommand publicKeyCommand1 = publicKeysService.add(publicKeyCommand);
        log.info("Suim");
        privateKeyService.add(privateKeyCommand);
        model.addAttribute("message", "");
        model.addAttribute("messages", "");
        return "pages/uploadresult.html";
    }

}
