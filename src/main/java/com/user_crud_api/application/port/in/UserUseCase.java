package com.user_crud_api.application.port.in;


import com.user_crud_api.model.User;

import java.util.List;

public interface UserUseCase {
    User create(User user);

    User update(Long id, User user);

    void delete(Long id);

    User getById(Long id);

    List<User> getAll();
}
