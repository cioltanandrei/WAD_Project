package org.example.xlr8travel.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/checkin4")
public class Checkin4Controller {
    @GetMapping
    public ModelAndView getTestData() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}