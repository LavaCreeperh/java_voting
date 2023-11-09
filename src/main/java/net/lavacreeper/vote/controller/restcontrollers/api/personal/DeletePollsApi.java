package net.lavacreeper.vote.controller.restcontrollers.api.personal;


import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class DeletePollsApi {
    @Autowired
    ChoiceService choiceService;
    @Autowired
    PollsService pollsService;

    @PostMapping("/api/deletePolls")
    public Message deletePolls(IdJson id, HttpSession session) {
        //TODO 确保用户登陆
        try {
            Integer userId = (Integer) session.getAttribute("USER_ID");
            if (userId == null) {
                return new Message("请先登陆", false);
            }
            //确保用户是这个poll的创建者
            if (!pollsService.getPollsById(id.getId()).getCreator_id().equals(userId)) {
                return new Message("你不是这个投票的创建者", false);
            }
            return choiceService.deleteByPollsId(id.getId());

        } catch (Exception e) {
            return new Message("出现错误", false);
        }


    }
}
