package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String guessNumber() {
        return "roll-dice";
    }

    public int random(){
        Random rand = new Random();
       int num= rand.nextInt((6 - 1) + 1) + 1;
        return num;
    }
@GetMapping("roll-dice/{n}")
    public String result(@PathVariable int n, Model viewModel){
    viewModel.addAttribute("userGuess", n);
    viewModel.addAttribute("result",random());
    return "roll-result";
}

}