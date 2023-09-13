package com.jlbooks.api.domain.users.repository;

import com.jlbooks.api.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
