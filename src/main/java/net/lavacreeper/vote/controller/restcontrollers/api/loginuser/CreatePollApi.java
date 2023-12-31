package net.lavacreeper.vote.controller.restcontrollers.api.loginuser;

import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.domain.PollFullJson;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CreatePollApi {
    @Autowired
    PollsService pollsService;
    @Autowired
    ChoiceService choiceService;

    @PostMapping("/api/createPoll")
    public Message createPoll(@RequestBody PollFullJson pollFullJson, HttpSession session) {
        //确保非空
        Integer user_id = (Integer) session.getAttribute("USER_ID");
        if (user_id == null) {
            return new Message("请先登陆", false);
        }
        Polls poll = pollFullJson.getPolls();
        List<Choices> choices = pollFullJson.getChoices();
        try {
            pollsService.createPollsByJson(poll, choices, user_id);
            return new Message("创建成功", true);
        } catch (Exception e) {
            return new Message("创建失败", false);
        }
    }
}
