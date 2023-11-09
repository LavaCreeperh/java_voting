package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.ChoiceDao;
import net.lavacreeper.vote.dao.PollsDao;
import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PollsServiceImpl implements PollsService {
    @Autowired
    PollsDao pollsDao;
    @Autowired
    ChoiceDao choiceDao;


    @Override
    public boolean save(Polls polls) {
        pollsDao.save(polls);
        return polls.getId() != null;
    }

    @Override
    public Polls getPollsById(Integer id) {
        return pollsDao.getPollsById(id);
    }

    //以下是通过userid获取到Polls
    @Override
    public List<Polls> getPollsByUserId(Integer userId) {
        return pollsDao.getPollsByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deletePollsById(Integer id) {
        try {
            pollsDao.delete(id);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updatePollsByJson(Polls polls, List<Choices> choices) {
        try {
            pollsDao.update(polls.getId(), polls.getQuestion());
            for (Choices choice : choices) {
                choiceDao.update(choice.getId(), choice.getDescription());
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createPollsByJson(Polls polls, List<Choices> choices, Integer userId) {
        try {
            polls.setCreator_id(userId);
            save(polls);
            Integer poll_id = polls.getId();
//            int a = 1/0;
            for (Choices choice : choices) {
                choice.setPoll_id(poll_id);
                choiceDao.save(choice);
            }
            return true;

        } catch (Exception e) {
            throw e;
        }
    }


}
