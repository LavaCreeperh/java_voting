package net.lavacreeper.vote.dao;


import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Polls;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

@Mapper
public interface ChoiceDao {

    @Insert("insert into choices (poll_id, description) VALUES (#{polls_id}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id", statementType = StatementType.PREPARED)
    public void save(Choices choices);

    @Update("update choices set description = #{description} where id = #{id}")
    public boolean update(Integer id, String description);
    public List<Choices> getByPollsId();
}
