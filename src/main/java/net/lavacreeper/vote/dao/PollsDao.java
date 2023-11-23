package net.lavacreeper.vote.dao;


import net.lavacreeper.vote.domain.Polls;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

@Mapper
public interface PollsDao {

    @Select("select count(*) from polls where id = #{userId}")
    public int getPollsCount(Integer userId);
    @Insert("insert into polls (question, creator_id, end_date) VALUES (#{question}, #{creator_id},#{end_date})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id", statementType = StatementType.PREPARED)
    public void save(Polls polls);
    @Select("select * from polls where creator_id = #{userId}")
    public List<Polls> getPollsByUserId(Integer userId);
    @Select("select * from polls where id = #{id}")
    public Polls getPollsById(Integer id);
    @Update("update polls set question = #{question} where id = #{id}")
    public boolean update(Integer id,String question);

    @Delete("delete from polls where id = #{id}")
    public boolean delete(Integer id);
}
