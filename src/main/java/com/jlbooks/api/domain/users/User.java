package com.jlbooks.api.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlbooks.api.domain.users.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private LocalDate created_at;

    public User(UserRequestDto userData) {
        this.name = userData.name();
        this.email = userData.email();
        this.password = userData.password();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }
}
