package com.example.soccerleaguemanager.controller;

import com.example.soccerleaguemanager.model.LeagueChampionship;
import com.example.soccerleaguemanager.model.SoccerTeam;
import com.example.soccerleaguemanager.repository.LeagueChampionshipRepository;
import com.example.soccerleaguemanager.repository.SoccerTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/championships")
public class LeagueChampionshipController {

    @Autowired
    private LeagueChampionshipRepository championshipRepository;

    @Autowired
    private SoccerTeamRepository soccerTeamRepository;

    @GetMapping
    public List<LeagueChampionship> getAllChampionships() {
        return championshipRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeagueChampionship> getChampionshipById(@PathVariable Long id) {
        return championshipRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public LeagueChampionship createChampionship(@RequestBody LeagueChampionship championship) {
        return championshipRepository.save(championship);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeagueChampionship> updateChampionship(@PathVariable Long id, @RequestBody LeagueChampionship championshipDetails) {
        return championshipRepository.findById(id)
                .map(championship -> {
                    championship.setName(championshipDetails.getName());
                    championship.setSeason(championshipDetails.getSeason());
                    championship.setCountry(championshipDetails.getCountry());
                    return ResponseEntity.ok(championshipRepository.save(championship));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChampionship(@PathVariable Long id) {
        return championshipRepository.findById(id)
                .map(championship -> {
                    championshipRepository.delete(championship);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{championshipId}/teams/{teamId}")
    public ResponseEntity<?> addTeamToChampionship(@PathVariable Long championshipId, @PathVariable Long teamId) {
        LeagueChampionship championship = championshipRepository.findById(championshipId).orElse(null);
        SoccerTeam team = soccerTeamRepository.findById(teamId).orElse(null);

        if (championship == null || team == null) {
            return ResponseEntity.notFound().build();
        }

        championship.getTeams().add(team);
        championshipRepository.save(championship);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{championshipId}/teams/{teamId}")
    public ResponseEntity<?> removeTeamFromChampionship(@PathVariable Long championshipId, @PathVariable Long teamId) {
        LeagueChampionship championship = championshipRepository.findById(championshipId).orElse(null);
        SoccerTeam team = soccerTeamRepository.findById(teamId).orElse(null);

        if (championship == null || team == null) {
            return ResponseEntity.notFound().build();
        }

        championship.getTeams().remove(team);
        championshipRepository.save(championship);
        return ResponseEntity.ok().build();
    }
} 