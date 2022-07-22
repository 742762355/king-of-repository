package com.lixin.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class IndexController {


    @GetMapping("/index.html")
    public String goIndex() {
        return "index";
    }

    @GetMapping("/2d.html")
    public String go2d() {
        return "2d";
    }
}
