package com.jlbooks.api.controllers;

import com.jlbooks.api.domain.users.User;
import com.jlbooks.api.domain.users.dto.DataListUsers;
import com.jlbooks.api.domain.users.dto.UserEditRequest;
import com.jlbooks.api.domain.users.dto.UserRequestDto;
import com.jlbooks.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

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
    public ResponseEntity findUsers(Pageable pageable){
        return  ResponseEntity.ok(userService.findAllUsers(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity findOneUser(@PathVariable UUID id){
        return ResponseEntity.ok(userService.findOneUser(id));
    }

//    @PutMapping("/{id}")
//    @Transactional
//    public ResponseEntity editUser(@PathVariable UUID id, @RequestBody @Valid UserEditRequest userData){
//        return ResponseEntity.ok();
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
    }
}
