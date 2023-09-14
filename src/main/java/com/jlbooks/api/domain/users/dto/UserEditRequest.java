package com.jlbooks.api.domain.users.dto;

import jakarta.validation.constraints.Email;


public record UserEditRequest(
        String name ,
        @Email
        String email ,
        String password
) { }
