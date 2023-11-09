package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.domain.UpdateJson;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UpdatePoll {
    @Autowired
    PollsService pollsService;
    @Autowired
    ChoiceService choiceService;

    @PostMapping("/api/updatePoll")
    public Message updatePoll(@RequestBody UpdateJson updateJson, HttpServletRequest request) {
        return null;

    }

}
