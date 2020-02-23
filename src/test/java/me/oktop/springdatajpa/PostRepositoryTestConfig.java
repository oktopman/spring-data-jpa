package me.oktop.springdatajpa;

import me.oktop.springdatajpa.domain.custom.PostListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {

    @Bean
    public PostListener postListenerBean() {
        return new PostListener();
    }
}
