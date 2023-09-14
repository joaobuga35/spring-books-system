package com.jlbooks.api.controllers;

import com.jlbooks.api.domain.users.User;
import com.jlbooks.api.domain.users.dto.DataListUsers;
import com.jlbooks.api.domain.users.dto.UserRequestDto;
import com.jlbooks.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity registerUser(@RequestBody @Valid UserRequestDto userData, UriComponentsBuilder uriBuilder){
       User newUser = userService.createUser(userData);
       var uri = uriBuilder.path("/users/{id}").buildAndExpand(newUser.getId()).toUri();
       return ResponseEntity.created(uri).body(new DataListUsers(newUser));
    }
    @GetMapping()
    public ResponseEntity findUsers(){
        return  ResponseEntity.ok("Hello World");
    }
}
