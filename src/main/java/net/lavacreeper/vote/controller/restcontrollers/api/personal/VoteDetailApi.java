package net.lavacreeper.vote.controller.restcontrollers.api.personal;


import net.lavacreeper.vote.domain.IdJson;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.domain.VoteDetail;
import net.lavacreeper.vote.service.PollsService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

//TODO 获取到用户所请求到的投票的详细信息，通过polls对象的id来获取，get方法
//TODO 验证用户否登录以及有相应的权限 返回的json为choice的list,choice id对应的数量以及polls对象
//返回值为一个polls对象，和一个choice的list，还有一个vote的list
//获取到的vote对应的choiceid，通过choiceid获取到每个choice具体的数量，这个由前端来做
@RestController
public class VoteDetailApi {

    @Autowired
    PollsService pollsService;


    @GetMapping("/api/getVoteDetail/{id}")
    public VoteDetail getVoteDetail(HttpSession session, @PathVariable String id) {
        //确保用户登陆
        Integer userId = (Integer) session.getAttribute("USER_ID");
        if (userId == null) {
            return null;
        }
        //确保是自己的投票,使用id到数据库里查询
        if (!Objects.equals(pollsService.getPollsById(Integer.parseInt(id)).getCreator_id(), userId)) {
            return null;
        }
        VoteDetail voteDetail = pollsService.getVoteDetail(Integer.parseInt(id));
        //返回对应的投票的详细信息
        return voteDetail;

    }

}
