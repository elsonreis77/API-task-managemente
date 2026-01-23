package com.elsonreis.API_task_management.repository;

import com.elsonreis.API_task_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
