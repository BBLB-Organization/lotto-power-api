package com.example.lottopower.repositories;

import com.example.lottopower.models.UserLeaderboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLeaderboardRepository extends JpaRepository<UserLeaderboard, String> {
}
