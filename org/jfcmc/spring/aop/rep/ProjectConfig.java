package org.jfcmc.spring.aop.rep;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ProjectConfig {
    @Bean
    public CommentService commentService() {
        return new CommentService();
    }
}
