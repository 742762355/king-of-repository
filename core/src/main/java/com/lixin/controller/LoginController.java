package com.lixin.controller;

import com.lixin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired(required = false)
    private BaseService baseService;

    @PostMapping("/login")
    public String login() {
        return "111";
    }

    @GetMapping("/login")
    public String login1() {
        return "111";
    }
}
