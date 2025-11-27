package com.user_crud_api.adapter.out.db;

import com.user_crud_api.application.port.out.UserRepositoryPort;
import com.user_crud_api.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    public UserRepositoryAdapter(UserRepository repo) {
        this.userRepository = repo;
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        return toModel(userRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .map(this::toModel)
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().map(this::toModel).toList();
    }

    private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();

        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());

        return entity;
    }

    private User toModel(UserEntity entity) {
        User user = new User();

        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());

        return user;
    }

}
