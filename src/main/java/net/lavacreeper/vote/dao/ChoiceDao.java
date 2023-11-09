package net.lavacreeper.vote.dao;


import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Polls;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

@Mapper
public interface ChoiceDao {

    @Insert("insert into choices (poll_id, description) VALUES (#{poll_id}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id", statementType = StatementType.PREPARED)
    public void save(Choices choices);

    @Update("update choices set description = #{description} where id = #{id}")
    public boolean update(Integer id, String description);

    @Select("select * from choices where poll_id = #{poll_id}")
    public List<Choices> getByPollsId(Integer poll_id);

    @Delete("delete from choices where id = #{id}")
    public boolean delete(Integer id);

    @Select("select * from choices where id = #{id}")
    public Choices getChoiceById(Integer id);
}
