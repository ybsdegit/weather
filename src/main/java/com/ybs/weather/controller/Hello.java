package com.ybs.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello
 *
 * @author Paulson
 * @date 2020/1/8 21:49
 */
@Controller
public class Hello {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name",
            required = false,
            defaultValue = "World") String name,
                           Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("")
    public String  hello(){
        return "redirect:/report/weather";
    }
}
