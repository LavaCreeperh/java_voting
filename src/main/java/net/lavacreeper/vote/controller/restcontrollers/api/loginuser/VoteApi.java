package net.lavacreeper.vote.controller.restcontrollers.api.loginuser;

import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.CFService;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.UserService;
import net.lavacreeper.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class VoteApi {
    @Autowired
    VoteService voteService;
    @Autowired
    UserService userService;
    @Autowired
    CFService cfService;

    //这个id是choiceid
    @GetMapping("/api/vote/{id}/token/{token}")
    public Message vote(HttpSession session, @PathVariable String id, @PathVariable String token) {
        // 确保用户登陆
        // 确保用户没有在这个poll中投过票
        //DONE 过期的polls不能投票
        //DONE 验证码逻辑完成
        try {
            if (!cfService.check(token)) {
                return new Message("验证码错误", false);
            }
            Integer user_id = (Integer) session.getAttribute("USER_ID");
            if (id == null) {
                return new Message("请先登陆", false);
            }
            return voteService.vote(user_id, Integer.parseInt(id));
        } catch (Exception e) {
            return new Message("出现错误", false);
        }

    }
}
