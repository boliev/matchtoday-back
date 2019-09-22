package ru.matchtoday.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team guestTeam;

    @ManyToOne
    private Tournament tournament;

    @ManyToOne
    private TournamentStage tournamentStage;

    private Long lsId;

    private Timestamp datetime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    protected Match() {
    }

    public Match(Team homeTeam, Team guestTeam, Timestamp datetime, Tournament tournament, TournamentStage tournamentStage) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.tournament = tournament;
        this.tournamentStage = tournamentStage;
        this.datetime = datetime;
    }

    public Long getId() {
        return id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public TournamentStage getTournamentStage() {
        return tournamentStage;
    }

    public Date getDatetime() {
        return datetime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Long getLsId() {
        return lsId;
    }

    public void setLsId(Long lsId) {
        this.lsId = lsId;
    }
}