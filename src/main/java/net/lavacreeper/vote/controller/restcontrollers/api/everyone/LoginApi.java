package net.lavacreeper.vote.controller.restcontrollers.api.everyone;


import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSetTransactionStatement;
import net.lavacreeper.vote.domain.AuthMessage;
import net.lavacreeper.vote.domain.LoginMessage;
import net.lavacreeper.vote.exception.LoginException;
import net.lavacreeper.vote.service.CFService;
import net.lavacreeper.vote.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class LoginApi {
    @Autowired
    UserService userService;
    @Autowired
    CFService cfService;

    @PostMapping("/api/login")
    public LoginMessage login(@RequestBody AuthMessage authMessage, HttpServletRequest request) {
        try {
            //验证是否通过验证码
            if (!cfService.check(authMessage.getTurnstileToken())) {
                return new LoginMessage("验证码错误", false);
            }

            if (!authMessage.getUsername().matches("^[A-Za-z0-9]+$")) {
                return new LoginMessage("非法输入", false);
            }
            LoginMessage message = userService.login(authMessage);
            if (message.isSuccess()) {
                if (authMessage.isRememberMe()) {
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(60 * 60 * 24 * 7);
                    session.setAttribute("USER", authMessage.getUsername());
                    session.setAttribute("USER_ID", userService.getByUsername(authMessage.getUsername()).getId());
                } else {
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(60 * 60);
                    session.setAttribute("USER", authMessage.getUsername());
                    session.setAttribute("USER_ID", userService.getByUsername(authMessage.getUsername()).getId());
                }
                return message;


            }
            return message;

        } catch (LoginException e) {
            return new LoginMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
