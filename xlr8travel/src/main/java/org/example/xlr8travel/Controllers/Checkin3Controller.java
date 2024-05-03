package org.example.xlr8travel.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/checkin3")
public class Checkin3Controller {

    @GetMapping
    public ModelAndView getTestData() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
