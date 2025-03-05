package com.example.soccerleaguemanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "league_championships")
@Data
@NoArgsConstructor
public class LeagueChampionship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String season;
    
    private String country;

    @ManyToMany
    @JoinTable(
        name = "championship_teams",
        joinColumns = @JoinColumn(name = "championship_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<SoccerTeam> teams = new HashSet<>();
} 