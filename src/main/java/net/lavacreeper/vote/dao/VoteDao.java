package net.lavacreeper.vote.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VoteDao {

    @Insert("INSERT INTO votes (user_id,choice_id,poll_id) VALUES (#{user_id},#{choice_id},#{question_id})")
    public void vote(Integer user_id, Integer choice_id, Integer question_id);

    @Select("SELECT COUNT(*) FROM votes WHERE user_id=#{user_id} AND poll_id=#{poll_id}")
    public int hasVoted(Integer user_id, Integer poll_id);

    @Select("SELECT COUNT(*) FROM votes WHERE choice_id=#{choice_id}")
    public int getVoteCount(Integer choice_id);
}
