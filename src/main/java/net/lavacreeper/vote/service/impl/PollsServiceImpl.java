package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.ChoiceDao;
import net.lavacreeper.vote.dao.PollsDao;
import net.lavacreeper.vote.dao.VoteDao;
import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.NumberOfChoice;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.domain.VoteDetail;
import net.lavacreeper.vote.service.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PollsServiceImpl implements PollsService {
    @Autowired
    PollsDao pollsDao;
    @Autowired
    ChoiceDao choiceDao;
    @Autowired
    VoteDao voteDao;


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

    @Override
    public VoteDetail getVoteDetail(Integer id) {
        //造一个VoteDetail对象
        VoteDetail voteDetail = new VoteDetail();
        //先获取polls
        voteDetail.setPolls(pollsDao.getPollsById(id));
        //再获取choices
        List<Choices> choices = choiceDao.getByPollsId(id);
        List<NumberOfChoice> numberOfChoices = new ArrayList<>();
        for (Choices choice : choices) {
            numberOfChoices.add(new NumberOfChoice(choice.getId(), voteDao.getVoteCount(choice.getId()), choice.getDescription()));
        }
        voteDetail.setChoiceNumbers(numberOfChoices);
        return voteDetail;
    }


}
