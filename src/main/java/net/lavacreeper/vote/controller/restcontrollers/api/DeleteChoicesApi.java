package net.lavacreeper.vote.controller.restcontrollers.api;


import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class DeleteChoicesApi {
    @Autowired
    ChoiceService choiceService;
    @Autowired
    PollsService pollsService;

    @PostMapping("/api/deleteChoices")
    public Message deleteChoices(IdJson id, HttpSession session) {
        //TODO 确保用户登陆
        try {
            Integer userId = (Integer) session.getAttribute("USER_ID");
            //确保用户是这个poll的创建者
            if (!pollsService.getPollsById(id.getId()).getCreator_id().equals(userId)) {
                return new Message("你不是这个投票的创建者", false);
            }
            if (choiceService.deleteByPollsId(id.getId())) {
                return new Message("删除成功", true);
            }
            return new Message("删除失败", false);

        } catch (Exception e) {
            return new Message("出现错误", false);
        }


    }
}
