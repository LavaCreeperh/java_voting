package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.AuthMessage;
import net.lavacreeper.vote.domain.LoginMessage;
import net.lavacreeper.vote.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApi {
    @Autowired
    UserService userService;

    @PostMapping("/api/login")
    public LoginMessage login(@RequestBody AuthMessage authMessage) {
        try {
            return userService.login(authMessage);
        } catch (Exception e) {
            return
        }

    }
}
