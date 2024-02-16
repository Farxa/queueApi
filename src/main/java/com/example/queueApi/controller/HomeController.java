package com.example.queueApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "home"; // Name of the template that welcomes the user
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/oauth2/authorization/spotify"; // Trigger OAuth2 login with Spotify
    }
}

// @Controller
// public class HomeController {

// @GetMapping("/login")
// public String login() {

// return "redirect:/oauth2/authorization/spotify";
// }
// }
