package com.example.ExpiryCheck.repository;

import com.example.ExpiryCheck.schemas.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);
}
