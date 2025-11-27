package com.user_crud_api.adapter.in.web;

import com.user_crud_api.application.port.in.UserUseCase;
import com.user_crud_api.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    UserUseCase userUseCase;
    UserController userController;

    @BeforeEach
    void setUp() {
        userUseCase = mock(UserUseCase.class);
        userController = new UserController(userUseCase);
    }

    @Test
    void testCreate() {
        User user = new User(1L, "Joao", "joao@gmail.com");
        when(userUseCase.create(user)).thenReturn(user);

        User result = userController.create(user);

        assertEquals(user, result);
        verify(userUseCase).create(user);
    }

    @Test
    void testFindAll() {
        List<User> users = Arrays.asList(
                new User(1L, "John", "jon@gmail.com"),
                new User(2L, "Anna", "ana@gmail.com")
        );

        when(userUseCase.getAll()).thenReturn(users);

        List<User> result = userController.findAll();

        assertEquals(2, result.size());
        verify(userUseCase).getAll();
    }

    @Test
    void testFindById() {
        User user = new User(1L, "John", "jo@gmail.com");

        when(userUseCase.getById(1L)).thenReturn(user);

        User result = userController.findById(1L);

        assertEquals("John", result.getName());
        assertEquals("jo@gmail.com", result.getEmail());

        verify(userUseCase).getById(1L);
    }

    @Test
    void testUpdate() {

        User updated = new User(1L, "Updated", "updated@gmail.com");

        when(userUseCase.update(eq(1L), ArgumentMatchers.any(User.class)))
                .thenReturn(updated);

        userController.update(1L, updated);
        verify(userUseCase).update(1L, updated);
    }

    @Test
    void testDelete() {

        doNothing().when(userUseCase).delete(1L);
        userController.delete(1L);
        verify(userUseCase).delete(1L);
    }
}
