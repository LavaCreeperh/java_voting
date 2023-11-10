package net.lavacreeper.vote.domain;

import java.util.List;

public class PollFullJson {
    private Polls polls;
    private List<Choices> choices;

    public Polls getPolls() {
        return polls;
    }

    @Override
    public String toString() {
        return "UpdateJson{" +
                "polls=" + polls +
                ", choices=" + choices +
                '}';
    }

    public void setPolls(Polls polls) {
        this.polls = polls;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }
}
