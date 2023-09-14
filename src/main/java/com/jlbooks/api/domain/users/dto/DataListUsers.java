package com.jlbooks.api.domain.users.dto;

import com.jlbooks.api.domain.users.User;

import java.util.UUID;

public record DataListUsers(UUID id, String name, String email) {
    public DataListUsers(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}