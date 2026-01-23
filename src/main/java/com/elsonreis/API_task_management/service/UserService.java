package com.elsonreis.API_task_management.service;

import com.elsonreis.API_task_management.entity.User;
import com.elsonreis.API_task_management.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //pra que serve
    //tantos códigos?
    //se a vida
    //não é programada
    //e as melhores coisa
    //não tem lógica?

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            throw new RuntimeException("Email already in use");
        }
        return userRepository.save(user);
    }

    public java.util.List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        getUserById(id);
        userRepository.deleteById(id);
    }
}
