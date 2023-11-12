package net.lavacreeper.vote.controller.restcontrollers.api.loginuser;

import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.UserService;
import net.lavacreeper.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class VoteApi {
    @Autowired
    VoteService voteService;
    @Autowired
    UserService userService;

    @PostMapping("/api/vote")
    public Message vote(@RequestBody IdJson id, HttpSession session) {
        // 确保用户登陆
        // 确保用户没有在这个poll中投过票
        //TODO 过期的polls不能投票
        try {
            String username = (String) session.getAttribute("USER");
            if (username == null) {
                return new Message("请先登陆", false);
            }
            Integer userId = userService.getByUsername(username).getId();
            return voteService.vote(userId, id.getId());
        } catch (Exception e) {
            return new Message("出现错误", false);
        }

    }
}
