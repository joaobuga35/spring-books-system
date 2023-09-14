package com.jlbooks.api.services;

import com.jlbooks.api.domain.users.User;
import com.jlbooks.api.domain.users.dto.DataListUsers;
import com.jlbooks.api.domain.users.dto.UserEditRequest;
import com.jlbooks.api.domain.users.dto.UserRequestDto;
import com.jlbooks.api.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDto userData){
        User newUser = new User(userData);
        return userRepository.save(newUser);
    }

    public Page<DataListUsers> findAllUsers(@PageableDefault(sort = {"name"},size = 5) Pageable pageable){
        return userRepository.findAll(pageable).map(DataListUsers::new);
    }

    public Optional<User> findOneUser(UUID id){
        return userRepository.findById(id);
    }

//    public Optional<User> editUser(UserEditRequest userData, UUID id){
//        Optional<User> user = userRepository.findById(id);
//
//        user.updateUser(userData);
//        return user;
//    }

    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }
}
