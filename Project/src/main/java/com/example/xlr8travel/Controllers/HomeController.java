package com.example.xlr8travel.Controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping
    public String list(final Model model) {
        return "index.html";
    }
}
