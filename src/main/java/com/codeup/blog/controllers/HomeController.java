package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String sayHello() {
        return "This is a landing page!";

    }

    @GetMapping("/home")
    public String welcome(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name, Model vModel) {
        if (name.equals("megan")) {
            vModel.addAttribute("admin", true);

        }
        vModel.addAttribute("username", name.toUpperCase());
        return "home";

    }

}