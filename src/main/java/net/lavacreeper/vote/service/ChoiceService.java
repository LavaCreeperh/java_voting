package net.lavacreeper.vote.service;

import net.lavacreeper.vote.domain.Choices;

import java.util.List;

public interface ChoiceService {
    public boolean save(Choices choices);
    public boolean getByPollsId();

    public boolean saveWithList(List<Choices> list);
}
