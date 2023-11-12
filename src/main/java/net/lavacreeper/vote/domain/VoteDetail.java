package net.lavacreeper.vote.domain;

import java.util.List;

public class VoteDetail {
    private Polls polls;
    private List<NumberOfChoice> ChoiceNumbers;

    @Override
    public String toString() {
        return "VoteDetail{" +
                "polls=" + polls +
                ", ChoiceNumbers=" + ChoiceNumbers +
                '}';
    }

    public Polls getPolls() {
        return polls;
    }

    public void setPolls(Polls polls) {
        this.polls = polls;
    }

    public List<NumberOfChoice> getChoiceNumbers() {
        return ChoiceNumbers;
    }

    public void setChoiceNumbers(List<NumberOfChoice> choiceNumbers) {
        ChoiceNumbers = choiceNumbers;
    }
}
