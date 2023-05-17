package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{number1}/and/{number2}")
    @ResponseBody
    public String solution(@PathVariable int number1, @PathVariable int number2){
        int sum = number1 + number2;
        return String.valueOf(sum);
    }

    @GetMapping("/subtract/{number1}/minus/{number2}")
    @ResponseBody
    public String solution2(@PathVariable int number1,  @PathVariable int number2){
        int remainder = number1 - number2;
        return String.valueOf(remainder);
    }

    @GetMapping("/multiply/{number1}/times/{number2}")
    @ResponseBody
    public String solution3(@PathVariable int number1,@PathVariable int number2){
        int product = number1 * number2;
        return String.valueOf(product);
    }

    @GetMapping("/divide/{number1}/by/{number2}")
    @ResponseBody
    public String solution4(@PathVariable int number1, @PathVariable int number2){
        int result = number1 / number2;
        return String.valueOf(result);
    }
}
