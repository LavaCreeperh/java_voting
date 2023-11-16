package net.lavacreeper.vote.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @projectName: vote
 * @package: net.lavacreeper.vote.config
 * @className: AppConfig
 * @author: LavaCreeper
 * @description:
 * @date: 11/16/23 3:54 PM
 * @version: 1.0
 */

@Configuration
public class AppConfig {
    @Bean
    public FilterRegistrationBean<CustomFilter> customFilterRegistration() {
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomFilter());
        registrationBean.addUrlPatterns("/*"); // 应用于所有路径
        return registrationBean;
    }
}
