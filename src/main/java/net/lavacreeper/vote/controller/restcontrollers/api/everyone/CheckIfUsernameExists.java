package net.lavacreeper.vote.controller.restcontrollers.api.everyone;


import net.lavacreeper.vote.domain.IfExistsApiMessage;
import net.lavacreeper.vote.domain.UsernameJson;
import net.lavacreeper.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckIfUsernameExists {
    @Autowired
    UserService userService;

    //DONE 改为get方法
    @GetMapping("/api/exist/{id}")
    public IfExistsApiMessage checkIfUsernameExists(@PathVariable String id) {
        if (!id.matches("^[A-Za-z0-9]+$")) {
            return new IfExistsApiMessage("输入不合法", false);
        }
        return userService.checkIfUsernameExists(id);
    }

}
