package com.user_crud_api.config;

import com.user_crud_api.application.port.in.UserUseCase;
import com.user_crud_api.application.port.out.UserRepositoryPort;
import com.user_crud_api.application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserUseCase userUseCase(UserRepositoryPort repo) {
        return new UserService(repo);
    }
}

