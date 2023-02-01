package com.example.lottopower.repositories;

import com.example.lottopower.models.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatsRepository extends JpaRepository<UserStats, Integer> {
    UserStats findByEmailAddress(String emailAddress);
}
