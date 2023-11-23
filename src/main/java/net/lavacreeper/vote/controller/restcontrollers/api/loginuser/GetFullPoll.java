package net.lavacreeper.vote.controller.restcontrollers.api.loginuser;

import net.lavacreeper.vote.domain.PollFullJson;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.controller.restcontrollers.api.loginuser
 * @className: GetPoll
 * @author: LavaCreeper
 * @description: DONE
 * @date: 11/16/23 2:11 PM
 * @version: 1.0
 */

@RestController
public class GetFullPoll {
    @Autowired
    PollsService pollsService;

    @GetMapping("/api/getPoll/{id}")
    public PollFullJson getFullPoll(@PathVariable String id, HttpSession session) {
        //确保用户登录
        Integer user_id = (Integer) session.getAttribute("USER_ID");
        if (user_id == null) {
            return null;
        }
        return pollsService.getPollFullJsonById(Integer.parseInt(id));
    }
}
