package net.lavacreeper.vote.controller.restcontrollers.api;

import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.domain.UpdateJson;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreatePollApi {
    @Autowired
    PollsService pollsService;
    @Autowired
    ChoiceService choiceService;

    @PostMapping("/api/createPoll")
    public Message createPoll(UpdateJson updateJson) {
        //确保非空
        //TODO 确保用户登陆,并且通过session中的userid将polls的user_id设置为当前用户的id
        Polls poll = updateJson.getPolls();
        List<Choices> choices = updateJson.getChoices();
        try {
            pollsService.createPollsByJson(poll, choices);
            return new Message("创建成功", true);
        } catch (Exception e) {
            System.out.println(e);
            return new Message("创建失败", false);
        }
    }
}
