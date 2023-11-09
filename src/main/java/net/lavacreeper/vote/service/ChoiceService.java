package net.lavacreeper.vote.service;

import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Message;

import java.util.List;

public interface ChoiceService {
    public boolean save(Choices choices);

    public List<Choices> getByPollsId(Integer id);

    public boolean saveWithList(List<Choices> list);

    public Message deleteByPollsId(Integer id);

    public boolean updateByPollsId(List<Choices> list);

    public Choices getChoiceById(Integer id);

    //删除单个choice
    public Message deleteChoiceById(Integer id);


}
