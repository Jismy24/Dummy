package com.dummy.admin.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.dummy.admin.models.entities.User;
import com.dummy.admin.models.payload.UserRequest;
import com.dummy.admin.repositories.AdminRepository;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public User createUser(UserRequest request) {
        try {
            User user = new User();
            user.setId(null); // important for insert
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());

            return adminRepository.save(user);

        } catch (Exception e) {
            throw new RuntimeException("Error while creating user: " + e.getMessage(), e);
        }
    }

    // Get All
    public List<User> getAllUsers() {
        return adminRepository.findAll();
    }

    // Get By Id
    public Optional<User> getUserById(Integer id) {
        return adminRepository.findById(id);
    }

    // Update
    public User updateUser(Integer id, User user) {
        return adminRepository.findById(id).map(existing -> {
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setPassword(user.getPassword());
            return adminRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Delete
    public void deleteUser(Integer id) {
        adminRepository.deleteById(id);
    }
}
