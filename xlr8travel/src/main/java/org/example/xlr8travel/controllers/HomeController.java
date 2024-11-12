package org.example.xlr8travel.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.xlr8travel.models.Country;
import org.example.xlr8travel.repositories.CountryRepository;
import org.example.xlr8travel.services.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/", "/index"})
@RequiredArgsConstructor
public class HomeController {

    private final CountryRepository countryRepository;
    private final CountryService countryService;

    @GetMapping("/autocomplete")
    @ResponseBody
    public List<String> getSelectCountry(@RequestParam("term") String term) {
        return countryService.search(term);
    }

    @PostMapping("/sendData")
    public String selectCountry(@ModelAttribute("country") Country country, Model model) {
        model.addAttribute("selectedCountryName", country.getName());
        model.addAttribute("country", country);
        List<Country> countryList = countryRepository.findAll();
        model.addAttribute("countryList", countryList);
        return "redirect:index";
    }

    @GetMapping()
    public String list2(final Model model) {
        return "index";
    }
}
