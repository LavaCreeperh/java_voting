package net.lavacreeper.vote.controller.restcontrollers.api;

import net.lavacreeper.vote.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IfVoted {
    @Autowired
    ChoiceService choiceService;

    @PostMapping("/api/ifvoted")
    public String ifVoted() {
        //用session中的userid查询vote表，确认是否在这个poll中投过票
        //TODO 确保用户登陆
        return "ifvoted";
    }
}
