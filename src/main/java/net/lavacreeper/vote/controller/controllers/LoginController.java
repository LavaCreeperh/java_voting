package net.lavacreeper.vote.controller.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpSession session) {
        //如果已经登录，重定向到main
        if (session.getAttribute("USER_ID") != null) {
            return "redirect:/main";
        }

        return "login";
    }

}
