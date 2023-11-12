package net.lavacreeper.vote.controller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.controller.controllers
 * @className: NewPollController
 * @author: LavaCreeper
 * @description: TODO
 * @date: 11/12/23 5:20 PM
 * @version: 1.0
 */

@Controller
public class NewPollController {

    @GetMapping("/create")
    public String newPoll() {
        return "NewPollPage";
    }

}
