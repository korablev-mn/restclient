package ru.korablev.restclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String Login() {
        return "redirect:/home";
    }

    @PostMapping(value = "/logout")
    public String Logout() {
        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String start() {
        return "login";
    }
}