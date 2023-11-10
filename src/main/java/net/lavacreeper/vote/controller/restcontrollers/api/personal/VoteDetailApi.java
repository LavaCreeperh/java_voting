package net.lavacreeper.vote.controller.restcontrollers.api.personal;


import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

//TODO 获取到用户所请求到的投票的详细信息，通过polls对象的id来获取，get方法
//TODO 验证用户否登录以及有相应的权限 返回的json为choice的list,choice id对应的数量以及polls对象
//返回值为一个polls对象，和一个choice的list，还有一个vote的list
//获取到的vote对应的choiceid，通过choiceid获取到每个choice具体的数量，这个由前端来做
@RestController
public class VoteDetailApi {


    @PostMapping("/api/getVoteDetail")
    public Message getVoteDetail(@RequestBody IdJson id, HttpSession session) {
        //确保用户登陆
        Integer userId = (Integer) session.getAttribute("USER_ID");
        if (userId == null) {
            return new Message("请先登陆", false);
        }
        return null;
    }

}
