package com.java.demo.c.c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OAuthCallback {
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code){

        return "index";
    }
}
