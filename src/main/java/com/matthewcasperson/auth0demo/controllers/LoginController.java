// src/main/java/com/matthewcasperson/auth0demo/controllers/LoginController.java

package com.matthewcasperson.auth0demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request) {
        return "redirect:/oauth2/authorization/auth0";
    }
}