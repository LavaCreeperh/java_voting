package net.lavacreeper.vote.controller.restcontrollers.api;


import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSetTransactionStatement;
import net.lavacreeper.vote.domain.AuthMessage;
import net.lavacreeper.vote.domain.LoginMessage;
import net.lavacreeper.vote.exception.LoginException;
import net.lavacreeper.vote.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginApi {
    @Autowired
    UserService userService;

    @PostMapping("/api/login")
    public LoginMessage login(@RequestBody AuthMessage authMessage, HttpServletRequest request) {
        try {
            if (!authMessage.getUsername().matches("^[A-Za-z0-9]+$")) {
                return new LoginMessage("非法输入", false);
            }
            LoginMessage message = userService.login(authMessage);
            if (message.isSuccess()) {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60 * 60 * 24 * 7);
                session.setAttribute("USER", authMessage.getUsername());

                return message;


            }
            return message;

        } catch (LoginException e) {
            return new LoginMessage();
        }

    }
}
