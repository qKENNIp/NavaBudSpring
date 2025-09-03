package org.nava.navabudspring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String navabud() {
        return "index";
    }
    @GetMapping("/working-example")
    public String workingExample() {
        return "WorkingExamplTempleyt";
    }
}
