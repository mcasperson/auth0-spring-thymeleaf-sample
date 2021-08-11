package com.matthewcasperson.auth0demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExternalApiController {
    @GetMapping("/external-api")
    public String profile() {
        return "externalapi";
    }
}
