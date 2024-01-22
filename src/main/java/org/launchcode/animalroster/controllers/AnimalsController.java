package org.launchcode.animalroster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/animals") // index method routes to localhost:8080/animals
public class AnimalsController {

    private final Map<String, String> roster = new LinkedHashMap<>();

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roster", roster);
        return "animals/index"; // templates/animals/index.html
    }

    @GetMapping("/add")
    public String add() {
        return "animals/add";
    }

    @PostMapping("/add")
    public String processAddForm(@RequestParam String caretaker, String animal) {
        roster.put(animal, caretaker);
        return "redirect:/animals";
    }
}
