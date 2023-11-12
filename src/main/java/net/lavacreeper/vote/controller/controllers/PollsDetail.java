package net.lavacreeper.vote.controller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.controller.controllers
 * @className: PollsDetail
 * @author: LavaCreeper
 * @description:
 * @date: 11/12/23 3:58 PM
 * @version: 1.0
 */

@Controller
public class PollsDetail {
    @GetMapping("/main/polls/{id}")
    public String pollsDetail(@PathVariable String id) {
        return "PollsDetailPage";
    }
}
