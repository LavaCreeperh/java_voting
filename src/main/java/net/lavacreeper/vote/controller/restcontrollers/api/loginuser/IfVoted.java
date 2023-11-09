package net.lavacreeper.vote.controller.restcontrollers.api.loginuser;

import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IfVoted {
    @Autowired
    VoteService voteService;

    //idjson存储的id是当前问题的id
    @PostMapping("/api/ifvoted")
    public Message ifVoted(@RequestBody IdJson idJson, HttpServletRequest session) {
        //用session中的userid查询vote表，确认是否在这个poll中投过票
        //TODO 确保用户登陆
        //从session中获取到当前登陆用户的id
        try {
            String userid = (String) session.getAttribute("USER");
            if (userid == null) {
                return new Message("请先登陆", false);
            }
            return voteService.hasVoted(userid, idJson.getId());
        } catch (Exception e) {
            return new Message("请先登陆", false);
        }

    }
}
