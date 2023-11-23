package net.lavacreeper.vote.service;

import net.lavacreeper.vote.domain.Message;

public interface VoteService {
    public Message vote(Integer user_id, Integer choice_id);

    public int getVoteCount(Integer question_id);

    public Message hasVoted(String username, Integer question_id);
}
