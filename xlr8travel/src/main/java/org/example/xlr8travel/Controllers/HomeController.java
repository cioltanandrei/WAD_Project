package org.example.xlr8travel.Controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class HomeController {

    @GetMapping
    public String list() {
        return "index";
    }

    @GetMapping("2")
    public String list2(final Model model) {
        return "index2";
    }
}
