package ru.matchtoday.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "tournament_stages")
public class TournamentStage {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Tournament tournament;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    protected TournamentStage() {
    }

    public TournamentStage(String name, Tournament tournament) {
        this.name = name;
        this.tournament = tournament;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}