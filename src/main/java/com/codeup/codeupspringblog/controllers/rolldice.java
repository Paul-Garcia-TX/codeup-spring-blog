package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class rolldice {
    @GetMapping("/roll-dice")
    public String rollDice(@RequestParam(required = false) List<Integer> guess, Model model) {
        List<Integer> diceRolls = new ArrayList<>();

        if (guess != null && !guess.isEmpty()) {
            Random random = new Random();

            for (int i = 0; i < guess.size(); i++) {
                int diceRoll = random.nextInt(6) + 1;
                diceRolls.add(diceRoll);
            }
        }

        model.addAttribute("guess", guess);
        model.addAttribute("diceRolls", diceRolls);
        model.addAttribute("isCorrect", checkGuesses(guess, diceRolls));

        return "roll-dice";
    }

    private List<Boolean> checkGuesses(List<Integer> guess, List<Integer> diceRolls) {
        List<Boolean> isCorrectList = new ArrayList<>();

        if (guess != null && diceRolls != null) {
            for (int i = 0; i < guess.size(); i++) {
                int guessNumber = guess.get(i);
                int diceRoll = diceRolls.get(i);
                boolean isCorrect = guessNumber == diceRoll;
                isCorrectList.add(isCorrect);
            }
        }

        return isCorrectList;
    }
}
