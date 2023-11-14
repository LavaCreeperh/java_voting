package net.lavacreeper.vote.controller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.controller.controllers
 * @className: UpdatePoll
 * @author: LavaCreeper
 * @description: DONE
 * @date: 11/13/23 2:47 PM
 * @version: 1.0
 */
@Controller
public class UpdatePoll {
    @GetMapping("updatePoll/{id}")
    public String updatePoll(@PathVariable String id) {
        return "updatePoll";
    }

}
