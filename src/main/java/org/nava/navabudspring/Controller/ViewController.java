package org.nava.navabudspring.Controller;

import org.nava.navabudspring.Entity.ClientDate;
import org.nava.navabudspring.ServisLayer.ServiceLayer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

@Controller
public class ViewController {

    private final ServiceLayer serviceLayer;

    public ViewController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("clientDate", new ClientDate());
        return "index";
    }
    @PostMapping("/send")
    public String send(@ModelAttribute("clientDate") ClientDate clientDate) {
        serviceLayer.addClient(clientDate);
        System.out.println("Sent clientDate: " + clientDate);
        return "redirect:/";
    }

    @GetMapping("/work-example")
    public String showWorkExamples() {
        return "WorkingExamplTempleyt";
    }


}
