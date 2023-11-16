package net.lavacreeper.vote.controller.restcontrollers.api.personal;


import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
public class DeleteChoiceApi {
    @Autowired
    ChoiceService choiceService;
    @Autowired
    PollsService pollsService;

    @GetMapping("/api/deleteChoice/{ChoiceId}")
    //id是choice的id
    public Message deleteChoice(@PathVariable String ChoiceId, HttpSession session) {

        // 删除choice
        try {
            //确保用户登陆
            Integer user_id = (Integer) session.getAttribute("USER_ID");
            if (user_id == null) {
                return new Message("请先登陆", false);
            }
            //确保用户是这个choice所属poll的创建者
            Integer id = Integer.parseInt(ChoiceId);
            Integer pollId = choiceService.getChoiceById(id).getPoll_id();
            if (!Objects.equals(pollsService.getPollsById(pollId).getCreator_id(), user_id)) {
                return new Message("你不是这个投票的创建者", false);
            }
            return choiceService.deleteChoiceById(id);
        } catch (Exception e) {
            return new Message("删除失败", false);
        }
    }
}
