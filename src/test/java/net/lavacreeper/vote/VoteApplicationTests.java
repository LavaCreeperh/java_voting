package net.lavacreeper.vote;

import net.lavacreeper.vote.dao.ChoiceDao;
import net.lavacreeper.vote.dao.PollsDao;
import net.lavacreeper.vote.dao.UserDao;
import net.lavacreeper.vote.domain.*;
import net.lavacreeper.vote.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    @Autowired
    ChoiceService choiceService;
    @Autowired
    VoteService voteService;
    @Autowired
    ChoiceDao choiceDao;
    @Autowired
    CFService cfService;

    @Test
    void testgetByPollsId() throws IOException {
        System.out.println(cfService.check("123456"));
    }

    @Test
    void homework() {
//        System.out.println("1"+(2+3));
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        hashMap.put(20,30);
//        System.out.println(hashMap.getOrDefault(20,0));
//        System.out.println(hashMap.get(20));

    }

    @Test
    void testGetVoteDetail() {
    System.out.println(pollsService.getVoteDetail(16));
}
    @Test
    void TestChoiceDao() {
        choiceDao.update(26, "test");
    }

    @Test
    void TestUpDatePoll() {
        Polls polls = new Polls();
        polls.setId(15);
        polls.setQuestion("贝拉今天吃什么？");
        polls.setCreator_id(1);
        List<Choices> choices = new ArrayList<>();
        choices.add(new Choices(26, 15, "麻辣烫"));
        choices.add(new Choices(27, 15, "麻辣香锅"));
        choices.add(new Choices(28, 15, "烤肉"));
        choices.add(new Choices(29, 15, "123"));
        choices.add(new Choices(30, 15, "烤猪"));
        pollsService.updatePollsByJson(polls, choices);
    }

    @Test
    void testGetPollsByUserId() {
        System.out.println(pollsService.getPollsByUserId(1));
    }

    @Test
    void TestDeletePolls() {
        System.out.println(pollsService.deletePollsById(14));
    }

    @Test
    void TestDeleteChoice() {
        System.out.println(choiceService.deleteChoiceById(1));
    }

    @Test
    void test_createPoll() {

        Polls polls = new Polls();
        polls.setQuestion("李奕今天吃什么？");
        polls.setCreator_id(1);
        polls.setEnd_date("2024-11-12 12:12:12");
        List<Choices> choices = new ArrayList<>();
        choices.add(new Choices("中药"));
        choices.add(new Choices("西药"));
        choices.add(new Choices("中西药"));
        boolean result;
        try {
            boolean res = pollsService.createPollsByJson(polls, choices, 1);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    @Test
    void TestIfVoted() {
        System.out.println(voteService.hasVoted("lavacreeper", 8));
    }

    @Test
    void TestVoteApi() {
        System.out.println(voteService.vote(1, 1));
    }

    @Test
    void test_getByPollsId() {
        IdJson idJson = new IdJson();
        idJson.setId(8);
        System.out.println(choiceService.getByPollsId(idJson.getId()));
    }

    @Test
    void test_register() {

        RegisterJson user = new RegisterJson();
        user.setUsername("lavacreeper");
        user.setPassword("1234");
        user.setEmail("abc@123.com");
        System.out.println(userService.register(user));
    }

    @Test
    void test_Login() {
        AuthMessage authMessage = new AuthMessage();
        authMessage.setUsername("lavacreeper");
        authMessage.setPassword("1234");
        authMessage.setRememberMe(true);
        System.out.println(userService.login(authMessage));
    }

    @Test
    void check_exists() {
        IfExistsApiMessage exists = userService.checkIfUsernameExists("lavacreeper");
        System.out.println(exists);
    }



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
