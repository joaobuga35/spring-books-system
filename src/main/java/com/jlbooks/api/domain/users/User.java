package com.jlbooks.api.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlbooks.api.domain.users.dto.UserEditRequest;
import com.jlbooks.api.domain.users.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
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
    @Column(length = 95,nullable = false)
    private String name;
    @Column(length = 255, nullable = false, unique = true)
    private String email;
    @Column(columnDefinition = "TEXT", nullable = false)
    @JsonIgnore
    private String password;
    @CreatedDate
    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp default now()")
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp default now()")
    private Timestamp updated_at = new Timestamp(System.currentTimeMillis());

    public User(UserRequestDto userData) {
        this.name = userData.name();
        this.email = userData.email();
        this.password = userData.password();
    }

    public void updateUser(UserEditRequest userData){
        if(userData.name() != null){
            this.name = userData.name();
        }

        if(userData.email() != null){
            this.email = userData.email();
        }

        if(userData.password() != null){
            this.password = userData.password();
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
