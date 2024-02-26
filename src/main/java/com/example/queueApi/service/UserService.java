package com.example.queueApi.service;

import com.example.queueApi.model.User;
import com.example.queueApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User ensureUserExists(String id, String displayName) {
        return userRepository.findById(id).orElseGet(() -> {
            User newUser = new User(id, displayName);
            return userRepository.save(newUser);
        });
    }
}
