package com.jlbooks.api.services;

import com.jlbooks.api.domain.users.User;
import com.jlbooks.api.domain.users.dto.UserRequestDto;
import com.jlbooks.api.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDto userData){
        User newUser = new User(userData);
        return userRepository.save(newUser);
    }
}
