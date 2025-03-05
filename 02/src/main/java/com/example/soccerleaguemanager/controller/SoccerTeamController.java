package com.example.soccerleaguemanager.controller;

import com.example.soccerleaguemanager.model.SoccerTeam;
import com.example.soccerleaguemanager.repository.SoccerTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class SoccerTeamController {

    @Autowired
    private SoccerTeamRepository soccerTeamRepository;

    @GetMapping
    public List<SoccerTeam> getAllTeams() {
        return soccerTeamRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoccerTeam> getTeamById(@PathVariable Long id) {
        return soccerTeamRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SoccerTeam createTeam(@RequestBody SoccerTeam team) {
        return soccerTeamRepository.save(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoccerTeam> updateTeam(@PathVariable Long id, @RequestBody SoccerTeam teamDetails) {
        return soccerTeamRepository.findById(id)
                .map(team -> {
                    team.setName(teamDetails.getName());
                    team.setCity(teamDetails.getCity());
                    team.setCountry(teamDetails.getCountry());
                    return ResponseEntity.ok(soccerTeamRepository.save(team));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
        return soccerTeamRepository.findById(id)
                .map(team -> {
                    soccerTeamRepository.delete(team);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 