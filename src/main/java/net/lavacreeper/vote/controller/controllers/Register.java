package net.lavacreeper.vote.controller.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Register {
    @GetMapping("/register")
    public String register(HttpSession session) {
        //如果已经登录，重定向到main
        if (session.getAttribute("USER_ID") != null) {
            return "redirect:/main";
        }
        return "register";
    }
}
