package com.dummy.admin.services;

import java.util.List;
import java.util.Optional;

import com.dummy.admin.models.entities.User;

public interface IAdminService {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Integer id);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);
}