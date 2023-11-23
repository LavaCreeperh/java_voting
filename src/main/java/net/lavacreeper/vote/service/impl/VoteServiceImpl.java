package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.ChoiceDao;
import net.lavacreeper.vote.dao.PollsDao;
import net.lavacreeper.vote.dao.UserDao;
import net.lavacreeper.vote.dao.VoteDao;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.domain.User;
import net.lavacreeper.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    VoteDao voteDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ChoiceDao choiceDao;
    @Autowired
    PollsDao pollDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Message vote(Integer user_id, Integer choice_id) {
        // 验证用户有没有投过票
        //DONE 验证是否存在这个choice
        try {
            //验证是否存在这个choice
            if (choiceDao.getChoiceById(choice_id) == null) {
                return new Message("不存在这个选项", false);
            }
            if (voteDao.hasVoted(user_id, choiceDao.getChoiceById(choice_id).getPoll_id()) != 0) {
                return new Message("你已经投过票了", false);
            }
            //DONE 验证是否过期
            String end_date = pollDao.getPollsById(choiceDao.getChoiceById(choice_id).getPoll_id()).getEnd_date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(end_date);
            if (date.before(new Date()) || date.equals(new Date())) {
                return new Message("投票已经结束", false);
            }
            Integer question_id = choiceDao.getChoiceById(choice_id).getPoll_id();
            voteDao.vote(user_id, choice_id, question_id);
            return new Message("投票成功", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public int getVoteCount(Integer question_id) {
        return voteDao.getVoteCountNumberByPollId(question_id);
    }

    @Override
    public Message hasVoted(String username, Integer question_id) {
        try {
            Integer userId = userDao.getByUsername(username).getId();
            int i = voteDao.hasVoted(userId, question_id);
            if (i != 0) {
                return new Message("已投票", true);

            } else {
                return new Message("未投票", true);
            }

        } catch (Exception e) {
            return new Message("出错", false);

        }
    }
}
