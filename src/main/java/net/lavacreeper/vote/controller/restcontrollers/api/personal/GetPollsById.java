package net.lavacreeper.vote.controller.restcontrollers.api.personal;

import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class GetPollsById {
    @Autowired
    PollsService pollsService;

    @GetMapping("/api/getPollsById")
    public List<Polls> getPollsById(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("USER_ID");
        if (userId == null) {
            // 可以选择返回空列表，或者适当的错误响应
            return null; // 或者使用 ResponseEntity 来返回一个错误响应
        }

        return pollsService.getPollsByUserId(userId);
    }
}


//package net.lavacreeper.vote.controller.restcontrollers.api.personal;
//
//
//import net.lavacreeper.vote.domain.IdJson;
//import net.lavacreeper.vote.domain.Polls;
//import net.lavacreeper.vote.service.PollsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
////这个是查看自己创建的投票的api
////确保用户登陆
//@RestController
//public class GetPollsById {
//    @Autowired
//    PollsService pollsService;
//
//    @PostMapping("/api/getPollsById")
//    public List<Polls> getPollsById(@RequestBody IdJson id, HttpSession session) {
//        Integer userId = (Integer) session.getAttribute("USER_ID");
//        if (userId == null) {
//            return null;
//        }
//        if (!userId.equals(id.getId())) {
//            return null;
//        }
//        return pollsService.getPollsByUserId(id.getId());
//    }
//}
