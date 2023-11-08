package net.lavacreeper.vote.dao;


import net.lavacreeper.vote.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

@Mapper
public interface UserDao {
    @Insert("INSERT INTO users(username, password, email) VALUES(#{username}, #{password}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id", statementType = StatementType.PREPARED)
    public void save(User user);

    @Select("SELECT * FROM users WHERE username = #{username}")
    public User getByUsername(String username);
    @Select("SELECT * FROM users WHERE email = #{email}")
    public User getByEmail(String email);


}
