package net.lavacreeper.vote.domain;

public class Votes {
    Integer id;
    Integer vote_user_id;

    Integer question_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVote_user_id() {
        return vote_user_id;
    }

    public void setVote_user_id(Integer vote_user_id) {
        this.vote_user_id = vote_user_id;
    }

    @Override
    public String toString() {
        return "Votes{" +
                "id=" + id +
                ", vote_user_id=" + vote_user_id +
                ", question_id=" + question_id +
                '}';
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }
}
