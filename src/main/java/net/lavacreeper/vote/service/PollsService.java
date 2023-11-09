package net.lavacreeper.vote.service;

import net.lavacreeper.vote.domain.Choices;
import net.lavacreeper.vote.domain.Polls;
import org.apache.tomcat.jni.Poll;

import java.util.List;

//这个是投票的service
//以下是poll表在数据库中的内容
//id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//                                       `question` TEXT NOT NULL, 问题
//                                       `creator_id` INT UNSIGNED NOT NULL, 创建者id
//                                       `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 创建时间
//                                       `end_date` TIMESTAMP NOT NULL, 结束时间
public interface PollsService {
    public boolean save(Polls polls);

    public Polls getPollsById(Integer id);

    public List<Polls> getPollsByUserId(Integer userId);

    public boolean deletePollsById(Integer id);

    public boolean updatePollsByJson(Polls polls, List<Choices> choices);

    public boolean createPollsByJson(Polls polls, List<Choices> choices, Integer userId);


}
