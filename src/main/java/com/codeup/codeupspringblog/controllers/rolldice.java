package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class rolldice {
    @GetMapping("/roll-dice")
    public String rollDice(@RequestParam(required = false) Integer guess, Model model) {
        if (guess != null && guess >= 1 && guess <= 6) {
            Random random = new Random();
            int diceRoll = random.nextInt(6) + 1;

            model.addAttribute("guess", guess);
            model.addAttribute("diceRoll", diceRoll);
            model.addAttribute("isCorrect", guess.equals(diceRoll));
        }

        return "roll-dice";
    }
}
