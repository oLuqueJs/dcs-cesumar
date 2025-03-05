package com.example.soccerleaguemanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "soccer_teams")
@Data
@NoArgsConstructor
public class SoccerTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;
    
    private String country;

    @ManyToMany(mappedBy = "teams")
    private Set<LeagueChampionship> championships = new HashSet<>();
} 