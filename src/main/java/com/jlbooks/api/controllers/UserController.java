package com.jlbooks.api.controllers;

import com.jlbooks.api.domain.users.User;
import com.jlbooks.api.domain.users.dto.UserRequestDto;
import com.jlbooks.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity registerUser(@RequestBody @Valid UserRequestDto userData){
       userService.createUser(userData);
       return ResponseEntity.ok(userData);
    }
    @GetMapping()
    public ResponseEntity findUsers(){
        return  ResponseEntity.ok("Hello World");
    }
}
