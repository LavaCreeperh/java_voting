package net.lavacreeper.vote.controller.restcontrollers.api.loginuser;


import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.service.ChoiceService;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
public class GetChoicesById {
    @Autowired
    ChoiceService choiceService;
    @Autowired
    PollsService pollsService;


    @PostMapping("/api/getChoicesById")
    public List<Choices> getChoicesById(@RequestBody IdJson id, HttpSession session) {
        //仅仅确认登陆即可，因为这个是投票对应选项的获取，不需要确认是否是创建者
        Integer user_id = (Integer) session.getAttribute("USER_ID");
        if (user_id == null) {
            return null;
        }
        return choiceService.getByPollsId(user_id);
    }

}
