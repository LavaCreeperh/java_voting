package net.lavacreeper.vote;

import net.lavacreeper.vote.dao.PollsDao;
import net.lavacreeper.vote.dao.UserDao;
import net.lavacreeper.vote.domain.Polls;
import net.lavacreeper.vote.domain.User;
import net.lavacreeper.vote.service.PollsService;
import net.lavacreeper.vote.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VoteApplicationTests {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    PollsService pollsService;
    @Autowired
    PollsDao pollsDao;


    @Test
    void contextLoads() {
    }

    @Test
    void getPollsByUserId(){
        User user = userDao.getByUsername("lavacreeper");
        System.out.println(pollsDao.getPollsByUserId(user.getId()));
    }

    @Test
    void insert_user(){
        User user = new User("lavacreeper","a@a.com","1233");
        System.out.println(userService.save(user));

    }

    @Test
    void getUserByUsername(){
        System.out.println(userDao.getByUsername("abcd"));

    }

    @Test
    void savePolls(){
        Polls polls = new Polls();
        polls.setQuestion("向晚今天吃什么？");
        polls.setCreator_id(1);
        polls.setEnd_date("2024-11-12 12:12:12");

        boolean result = pollsService.save(polls);
        System.out.println(result);

    }

}
