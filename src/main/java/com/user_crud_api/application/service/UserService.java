package com.user_crud_api.application.service;

import com.user_crud_api.application.port.in.UserUseCase;
import com.user_crud_api.application.port.out.UserRepositoryPort;
import com.user_crud_api.model.User;

import java.util.List;

public class UserService implements UserUseCase {

    private final UserRepositoryPort repo;

    public UserService(UserRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public User create(User user) {
        return repo.save(user);
    }

    @Override
    public User update(Long id, User user) {
        user.setId(id);
        return repo.save(user);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }

    @Override
    public User getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }
}
