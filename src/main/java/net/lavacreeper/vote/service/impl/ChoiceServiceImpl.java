package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.ChoiceDao;
import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService {

    @Autowired
    ChoiceDao choiceDao;

    @Override
    public boolean save(Choices choices) {
        choiceDao.save(choices);
        return choices.getId()!=null;
    }

    @Override
    public boolean getByPollsId() {
        return false;
    }

    @Override
    public boolean saveWithList(List<Choices> list) {
        for (Choices choices : list) {
            save(choices);
        }
        return true;
    }
}
