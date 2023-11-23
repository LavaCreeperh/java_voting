package net.lavacreeper.vote.controller.restcontrollers.api.loginuser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.controller.restcontrollers.api.loginuser
 * @className: Logout
 * @author: LavaCreeper
 * @description: DOne
 * @date: 11/20/23 9:41 AM
 * @version: 1.0
 */

//DONE 实现登出功能
@RestController
public class Logout {

    @GetMapping("/api/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("USER_ID");
        session.removeAttribute("USER");
    }

}
