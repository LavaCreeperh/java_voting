package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.ChoiceDao;
import net.lavacreeper.vote.dao.PollsDao;
import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Message;
import net.lavacreeper.vote.exception.SaveException;
import net.lavacreeper.vote.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService {

    @Autowired
    ChoiceDao choiceDao;
    @Autowired
    PollsDao pollsDao;

    @Override
    public boolean save(Choices choices) {
        choiceDao.save(choices);
        if (choices.getId() == null) {
            throw new SaveException("保存失败");
        } else {
            return true;
        }
    }

    @Override
    public List<Choices> getByPollsId(Integer id) {
        return choiceDao.getByPollsId(id);
    }

    @Override
    @Transactional(rollbackFor = SaveException.class)
    public boolean saveWithList(List<Choices> list) {
        for (Choices choices : list) {
            save(choices);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = SaveException.class)
    public Message deleteByPollsId(Integer id) {
        try {
            pollsDao.delete(id);
            for (Choices choices : choiceDao.getByPollsId(id)) {
                choiceDao.delete(choices.getId());
            }
            return new Message("删除成功", true);
        } catch (Exception e) {
            throw new SaveException("删除失败");
        }
        //删除polls
        //删除对应所有的choices

    }

    @Override
    public boolean updateByPollsId(List<Choices> list) {
        return false;
    }

    @Override
    public Choices getChoiceById(Integer id) {
        return choiceDao.getChoiceById(id);
    }

    @Override
    public Message deleteChoiceById(Integer id) {
        try {
            choiceDao.delete(id);
            return new Message("删除成功", true);
        } catch (Exception e) {
            throw new SaveException("删除失败");
        }
    }
}
