package com.user_crud_api.adapter.in.web;

import com.user_crud_api.application.port.in.UserUseCase;
import com.user_crud_api.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserUseCase useCase;

    public UserController(UserUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return useCase.create(user);
    }

    @GetMapping
    public List<User> findAll() {
        return useCase.getAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return useCase.getById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return useCase.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        useCase.delete(id);
    }
}
