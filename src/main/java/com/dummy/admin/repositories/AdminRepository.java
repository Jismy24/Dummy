package com.dummy.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dummy.admin.models.entities.User;

public interface AdminRepository extends JpaRepository<User, Integer> {
}