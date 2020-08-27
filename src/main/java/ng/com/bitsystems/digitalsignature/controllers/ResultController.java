package ng.com.bitsystems.digitalsignature.controllers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ng.com.bitsystems.digitalsignature.command.SessionCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class ResultController {

    @RequestMapping("/result/upload/")
    public String uploadResult(@ModelAttribute SessionCommand sessionCommand,
            @RequestParam("file") MultipartFile file, Model model){

        if (file.isEmpty()){
            model.addAttribute("message", "please select a .csv file");
            model.addAttribute("status", false);
        }
        else {

            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<Results> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Results.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<Results> results = csvToBean.parse();
                //results.forEach(result -> result.setSession());

                // TODO: save users in DB?

                // save users list on model
                model.addAttribute("results", results);
                model.addAttribute("status", true);
            }
            catch (IOException e){
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }
        return "";
    }
}
