package net.lavacreeper.vote.controller.restcontrollers.api.loginuser;

import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class IfVoted {
    @Autowired
    VoteService voteService;

    //idjson存储的id是当前问题的id
    @GetMapping("/api/ifvoted/{id}")
    public Message ifVoted(HttpSession session, @PathVariable String id) {
        //用session中的userid查询vote表，确认是否在这个poll中投过票
        // 确保用户登陆
        //从session中获取到当前登陆用户的id
        try {
            Integer userid = (Integer) session.getAttribute("USER_ID");
            if (userid == null) {
                return new Message("请先登陆", false);
            }
            Integer idInt = Integer.parseInt(id);
            return voteService.hasVoted((String) session.getAttribute("USER"), idInt);
        } catch (Exception e) {
            return new Message("请先登陆", false);
        }

    }
}
