package com.lixin.controller;


import com.lixin.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @RequiresPermissions(value = "*")
    @RequestMapping("/auth")
    public String doPermissions(){
        return "11";
    }
}
