package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class rolldice {
    @GetMapping("/roll-dice")
    public String dice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String rollDice(@PathVariable int number, Model model) {
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;

        model.addAttribute("number", number);
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("isCorrect", number == diceRoll);

        return "result-page";
    }
}
