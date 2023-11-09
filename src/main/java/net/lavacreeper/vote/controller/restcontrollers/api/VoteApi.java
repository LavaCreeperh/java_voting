package net.lavacreeper.vote.controller.restcontrollers.api;

import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteApi {
    @Autowired
    ChoiceService choiceService;

    @PostMapping("/api/vote")
    public Message vote(@RequestBody IdJson id) {
        //TODO 确保用户登陆
        //TODO 确保用户没有在这个poll中投过票
        return null;
    }
}
