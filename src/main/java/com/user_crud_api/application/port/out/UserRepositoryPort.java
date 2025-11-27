package com.user_crud_api.application.port.out;

import com.user_crud_api.model.User;

import java.util.List;

public interface UserRepositoryPort {
    User save(User user);

    void delete(Long id);

    User findById(Long id);

    List<User> findAll();
}