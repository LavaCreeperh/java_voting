package net.lavacreeper.vote.controller.restcontrollers.api.personal;


import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

//这个是查看自己创建的投票的api
//确保用户登陆
@RestController
public class GetPollsById {
    @Autowired
    PollsService pollsService;

    @PostMapping("/api/getPollsById")
    public List<Polls> getPollsById(@RequestBody IdJson id, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("USER_ID");
        if (userId == null) {
            return null;
        }
        if (!userId.equals(id.getId())) {
            return null;
        }
        return pollsService.getPollsByUserId(id.getId());
    }
}
