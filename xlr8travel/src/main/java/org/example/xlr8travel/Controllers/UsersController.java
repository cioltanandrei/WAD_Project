package org.example.xlr8travel.Controllers;


import org.example.xlr8travel.domain.User;
import org.example.xlr8travel.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showUsersForm(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
