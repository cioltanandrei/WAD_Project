package org.example.xlr8travel.controllers;

import org.example.xlr8travel.models.Flight;
import org.example.xlr8travel.services.FlightService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/add")
    public String showAddFlightForm(Model model,
                                    @RequestParam(value = "success", required = false) String success) {
        model.addAttribute("flight", new Flight());

        // If the query param ?success=1 is present, add a success message
        if (success != null) {
            model.addAttribute("successMessage", "Flight added successfully!");
        }
        return "addFlight"; // Renders addFlight.html
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/add")
    public String addFlight(@ModelAttribute("flight") Flight flight) {
        // Save the new flight
        flightService.save(flight);

        // Redirect back to the same page with a success indicator
        return "redirect:/flights/add?success=1";
    }

}