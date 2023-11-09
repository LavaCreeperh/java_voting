package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.IfExistsApiMessage;
import net.lavacreeper.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckIfUsernameExists {
    @Autowired
    UserService userService;


    @PostMapping("/api/checkIfUsernameExists")
    public IfExistsApiMessage checkIfUsernameExists(String username) {
        if (!username.matches("^[A-Za-z0-9]+$")) {
            return new IfExistsApiMessage("输入不合法", false);
        }
        return userService.checkIfUsernameExists(username);
    }

}
