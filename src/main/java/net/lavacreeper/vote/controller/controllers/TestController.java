package net.lavacreeper.vote.controller.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
