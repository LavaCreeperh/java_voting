package net.lavacreeper.vote.controller.restcontrollers.api.personal;


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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class UpdatePoll {
    @Autowired
    PollsService pollsService;
    @Autowired
    ChoiceService choiceService;

    //对发送过来对json的要求是必须有polls和choices两个字段，其中polls是一个polls对象，choices是一个choice对象的数组
//其中，choice和polls的id必须是已经存在的，而且choice的poll_id必须是polls的id
    @PostMapping("/api/updatePoll")
    public Message updatePoll(@RequestBody UpdateJson updateJson, HttpSession session) {
        // 1.校验用户的权限(这个poll属于当前session获取到的用户)
        try {
            Integer user_id = (Integer) session.getAttribute("USER_ID");
            if (user_id == null) {
                return new Message("请先登陆", false);
            }
            if (!Objects.equals(pollsService.getPollsById(updateJson.getPolls().getId()).getCreator_id(), user_id)) {
                return new Message("你不是这个投票的创建者", false);
            }
        //获取poll_id以及choice_id，调用service确认全部choice属于这个poll
        Polls poll = updateJson.getPolls();
        List<Choices> choices = new ArrayList<>(updateJson.getChoices());
        //2.确认choice全部为属于这个poll
        for (Choices choice : choices) {
            if (!Objects.equals(choiceService.getChoiceById(choice.getId()).getPoll_id(), poll.getId()) || (choiceService.getChoiceById(choice.getId()).getPoll_id() == null)) {
                return new Message("非法传入", false);
            }
        }
            //3.更新poll和choice
            return new Message("更新成功", pollsService.updatePollsByJson(poll, choices));
        } catch (Exception e) {
            return new Message("更新失败", false);
        }

    }

}