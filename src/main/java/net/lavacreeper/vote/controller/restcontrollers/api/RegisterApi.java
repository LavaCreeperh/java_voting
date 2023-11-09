package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.LoginMessage;
import net.lavacreeper.vote.domain.RegisterJson;
import net.lavacreeper.vote.domain.RegisterMessage;
import net.lavacreeper.vote.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterApi {
    @Autowired
    UserService userService;

    @PostMapping("/api/register")
    public RegisterMessage register(@RequestBody RegisterJson registerJson) {
        if ((!registerJson.getUsername().matches("^[A-Za-z0-9]+$")) ||
                (registerJson.getUsername() == null) ||
                (registerJson.getPassword() == null) ||
                (registerJson.getEmail() == null)) {
            return new RegisterMessage("非法输入", false);
        }
        //判断电子邮件是否合法
        if (!registerJson.getEmail().matches("^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            return new RegisterMessage("非法输入", false);
        }
        return userService.register(registerJson);
    }



}
