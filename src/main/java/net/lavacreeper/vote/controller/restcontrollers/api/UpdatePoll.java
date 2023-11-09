package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.domain.UpdateJson;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class UpdatePoll {
    @Autowired
    PollsService pollsService;
    @Autowired
    ChoiceService choiceService;

    @PostMapping("/api/updatePoll")
    public Message updatePoll(@RequestBody UpdateJson updateJson, HttpServletRequest request) {
        //确保非空
        //1.校验用户的权限(这个poll属于当前session获取到的用户)
        //获取poll_id以及choice_id，调用service确认全部choice属于这个poll
        Polls poll = updateJson.getPolls();
//        Integer poll_id = updateJson.getPolls().getId();
        List<Choices> choices = new ArrayList<>(updateJson.getChoices());
        //2.确认choice全部为属于这个poll
        for (Choices choice : choices) {
            if (!Objects.equals(choiceService.getChoiceById(choice.getId()).getPoll_id(), poll.getId()) || (choiceService.getChoiceById(choice.getId()).getPoll_id() == null)) {
                return new Message("非法传入", false);
            }
        }
        //3.更新poll
        if (pollsService.updatePollsByJson(poll, choices)) {
            return new Message("更新成功", true);
        }
        return new Message("更新失败", false);

    }

}
