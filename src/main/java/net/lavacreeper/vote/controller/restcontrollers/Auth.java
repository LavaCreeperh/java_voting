package net.lavacreeper.vote.controller.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Auth {
    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }
}
