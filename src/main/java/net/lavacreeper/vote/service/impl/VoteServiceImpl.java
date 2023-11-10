package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.ChoiceDao;
import net.lavacreeper.vote.dao.UserDao;
import net.lavacreeper.vote.dao.VoteDao;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.domain.User;
import net.lavacreeper.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    VoteDao voteDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ChoiceDao choiceDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Message vote(Integer user_id, Integer choice_id) {
        // 验证用户有没有投过票
        try {
            if (voteDao.hasVoted(user_id, choiceDao.getChoiceById(choice_id).getPoll_id()) != 0) {
                return new Message("你已经投过票了", false);
            }
            Integer question_id = choiceDao.getChoiceById(choice_id).getPoll_id();
            voteDao.vote(user_id, choice_id, question_id);
            return new Message("投票成功", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Message hasVoted(String username, Integer question_id) {
        try {
            Integer userId = userDao.getByUsername(username).getId();
            int i = voteDao.hasVoted(userId, question_id);
            if (i != 0) {
                return new Message("已投票", true);

            } else {
                return new Message("未投票", false);
            }

        } catch (Exception e) {
            return new Message("出错", false);

        }
    }
}
