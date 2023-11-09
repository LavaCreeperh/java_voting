package net.lavacreeper.vote.service;

import net.lavacreeper.vote.domain.Choices;

import java.util.List;

public interface ChoiceService {
    public boolean save(Choices choices);

    public List<Choices> getByPollsId(Integer id);

    public boolean saveWithList(List<Choices> list);

    public boolean deleteByPollsId(Integer id);

    public boolean updateByPollsId(List<Choices> list);

    public Choices getChoiceById(Integer id);
}
