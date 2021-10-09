// src/main/java/com/matthewcasperson/auth0demo/controllers/HomeController.java

package com.matthewcasperson.auth0demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String main() {
        return "index";
    }
}