package com.example.xlr8travel.Controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class HomeController {
    @GetMapping
    public String list(final Model model) {
        return "index.html";
    }
}
