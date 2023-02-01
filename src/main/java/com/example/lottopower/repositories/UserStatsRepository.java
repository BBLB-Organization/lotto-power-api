package com.example.lottopower.repositories;

import com.example.lottopower.models.UserStats;
import com.example.lottopower.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatsRepository extends JpaRepository<UserStats, Integer> {
    UserStats findByUsername(String username);
}
