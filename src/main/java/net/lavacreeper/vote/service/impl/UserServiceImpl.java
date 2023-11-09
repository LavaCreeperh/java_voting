package net.lavacreeper.vote.service.impl;

import net.lavacreeper.vote.dao.UserDao;
import net.lavacreeper.vote.domain.AuthMessage;
import net.lavacreeper.vote.domain.LoginMessage;
import net.lavacreeper.vote.domain.User;
import net.lavacreeper.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao bookDao;

    @Override
    public User getByUsername(String username) {
        return bookDao.getByUsername(username);
    }

    @Override
    public User getByEmail(String email) {
        return bookDao.getByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        User user = bookDao.getByUsername(username);
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
        bookDao.save(user);
        return user.getId() != null;
    }

    @Override
    public LoginMessage login(AuthMessage authMessage) {
        return null;
    }
}
