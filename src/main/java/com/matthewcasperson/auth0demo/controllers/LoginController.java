package com.matthewcasperson.auth0demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * https://stackoverflow.com/questions/53623746/bypassing-the-login-page-to-send-the-user-directly-to-the-authorization-uri
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request) {
        if (null != request.getQueryString()) {
            return "redirect:/profile";
        } else {
            return "redirect:/oauth2/authorization/auth0";
        }
    }
}
