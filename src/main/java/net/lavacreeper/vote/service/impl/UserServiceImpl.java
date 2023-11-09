package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.UserDao;
import net.lavacreeper.vote.domain.*;
import net.lavacreeper.vote.service.UserService;
import net.lavacreeper.vote.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        User user = userDao.getByUsername(username);
        if (user != null) {
            return Boolean.TRUE;
        }

        return false;
    }

    @Override
    public Boolean save(User user) {
        if(existsByUsername(user.getUsername())){
            return false;
        }
        userDao.save(user);
        return user.getId() != null;
    }

    @Override
    public LoginMessage login(AuthMessage authMessage) {
        String username = authMessage.getUsername();
        if (userDao.getByUsername(username) != null) {
            String hashedPassword = HashUtils.calculateSHA256(authMessage.getPassword());
            User user = userDao.loginMethod(username, hashedPassword);
            if (user != null) {
                return new LoginMessage("登录成功", true);
            } else {
                return new LoginMessage("用户名或密码错误", false);
            }


        }
        return new LoginMessage("用户名或密码错误", false);
    }

    @Override
    public RegisterMessage register(RegisterJson registerJson) {
        return null;
    }
}
