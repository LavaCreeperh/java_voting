package net.lavacreeper.vote.controller.restcontrollers.api.personal;

import net.lavacreeper.vote.service.PollsService;
import net.lavacreeper.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.controller.restcontrollers.api.personal
 * @className: GetPollCount
 * @author: LavaCreeper
 * @description: DONE
 * @date: 11/22/23 10:18 PM
 * @version: 1.0
 */

//DONE 实现获取投票数功能
@RestController
public class GetPollCount {
    @Autowired
    VoteService voteService;
    @Autowired
    PollsService pollsService;

    @GetMapping("/api/getPollCount/{id}")
    public Integer getPollCount(@PathVariable String id, HttpSession session) {
        Integer poll_id = Integer.parseInt(id);
        Integer user_id = (Integer) session.getAttribute("USER_ID");
        //判短是否登录
        if (user_id == null) {
            return -1;
        }
        //判断是否属于这个用户
        if (pollsService.getPollsById(poll_id).getId().equals(user_id)) {
            return voteService.getVoteCount(poll_id);
        } else {
            return -1;
        }
    }
}
