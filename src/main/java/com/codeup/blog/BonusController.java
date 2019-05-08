package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BonusController {
    @GetMapping("/test.json")
    @ResponseBody
    public String plainText(){

        return "view an individual page";
    }
}
