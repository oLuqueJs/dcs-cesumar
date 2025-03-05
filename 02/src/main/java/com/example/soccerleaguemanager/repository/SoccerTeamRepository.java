package com.example.soccerleaguemanager.repository;

import com.example.soccerleaguemanager.model.SoccerTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoccerTeamRepository extends JpaRepository<SoccerTeam, Long> {
} 