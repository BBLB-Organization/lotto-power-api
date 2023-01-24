package com.example.lottopower.repositories;

import com.example.lottopower.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
    Users findByEmailAddress(String emailAddress);
}
