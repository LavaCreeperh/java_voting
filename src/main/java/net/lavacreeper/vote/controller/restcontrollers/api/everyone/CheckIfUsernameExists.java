package net.lavacreeper.vote.controller.restcontrollers.api.everyone;


import net.lavacreeper.vote.domain.IfExistsApiMessage;
import net.lavacreeper.vote.domain.UsernameJson;
import net.lavacreeper.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckIfUsernameExists {
    @Autowired
    UserService userService;

    //TODO 改为get方法
    @PostMapping("/api/exist")
    public IfExistsApiMessage checkIfUsernameExists(@RequestBody UsernameJson username) {
        if (!username.getUsername().matches("^[A-Za-z0-9]+$")) {
            return new IfExistsApiMessage("输入不合法", false);
        }
        return userService.checkIfUsernameExists(username.getUsername());
    }

}
