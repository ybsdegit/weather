package com.ybs.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello
 *
 * @author Paulson
 * @date 2020/1/8 21:49
 */
@RestController
public class Hello {

    @GetMapping("")
    public String  hello(){
        return "hello";
    }
}
