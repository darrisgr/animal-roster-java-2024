package org.launchcode.animalroster.controllers;

import data.AnimalData;
import models.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/animals") // index method routes to localhost:8080/animals
public class AnimalsController {


    @GetMapping
    public String index(Model model) {
        model.addAttribute("roster", AnimalData.getAll());
        return "animals/index"; // templates/animals/index.html
    }

    @GetMapping("/add")
    public String add() {
        return "animals/add";
    }

    @PostMapping("/add")
    public String processAddForm(@ModelAttribute Animal newAnimal) {
        AnimalData.add(newAnimal);
        return "redirect:/animals";
    }

    @GetMapping("/remove")
    public String remove(Model model) {
        model.addAttribute("title", "Remove Animal(s)");
        model.addAttribute("roster", AnimalData.getAll());
        return "animals/remove";
    }

    @PostMapping("/remove")
    public String processRemoveAnimalForm(@RequestParam(required = false) int[] animalIds) {
        if (animalIds != null) {
            for (int id : animalIds) {
                AnimalData.remove(id);
            }
        }

        return "redirect:/animals";
    }

}
