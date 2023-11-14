package net.lavacreeper.vote.controller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.controller.controllers
 * @className: VotePage
 * @author: LavaCreeper
 * @description: DONE
 * @date: 11/13/23 2:48 PM
 * @version: 1.0
 */


@Controller
public class VotePage {
    @GetMapping("/vote/{id}")
    public String vote(@PathVariable String id) {
        return "vote";
    }
}
