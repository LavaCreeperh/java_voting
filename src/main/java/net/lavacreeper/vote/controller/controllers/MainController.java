package net.lavacreeper.vote.controller.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }
}
