package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.PollsDao;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.service.PollsService;
import org.apache.tomcat.jni.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollsServiceImpl implements PollsService {
    @Autowired
    PollsDao pollsDao;

    @Override
    public boolean save(Polls polls) {
        pollsDao.save(polls);
        return polls.getId() != null;
    }

    @Override
    public Polls getPollsById(Integer id) {
        return pollsDao.getPollsById(id);
    }

    @Override
    public List<Polls> getPollsByUserId(Integer userId) {
        return pollsDao.getPollsByUserId(userId);
    }
}
