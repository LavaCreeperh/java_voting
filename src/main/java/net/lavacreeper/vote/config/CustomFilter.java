package net.lavacreeper.vote.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.config
 * @className: CustomFilter
 * @author: LavaCreeper
 * @description:
 * @date: 11/16/23 3:48 PM
 * @version: 1.0
 */
public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;

        HttpSession session = httpReq.getSession(false); // 获取session但不创建新的session
        String uri = httpReq.getRequestURI();

        if (uri.startsWith("/login") || uri.startsWith("/api") || uri.startsWith("/register") || uri.startsWith("/static") || uri.startsWith("/error") || uri.startsWith("/favicon.ico")) {
            filterChain.doFilter(servletRequest, servletResponse); // 允许访问公共页面
            return;
        }

        if (session != null && session.getAttribute("USER_ID") != null) {
            filterChain.doFilter(servletRequest, servletResponse); // 如果session中有用户信息，继续处理请求
        } else {
            httpRes.sendRedirect("/login"); // 未登录，重定向到登录页面
        }

    }
}
