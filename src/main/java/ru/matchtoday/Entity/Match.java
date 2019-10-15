package ru.matchtoday.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team guestTeam;

    @ManyToOne
    private Tournament tournament;

    @ManyToOne
    private TournamentStage tournamentStage;

    @JsonIgnore
    private String lsId;

    private Timestamp datetime;

    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updatedAt;

    public Match() {
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

    public String getLsId() {
        return lsId;
    }

    public void setLsId(String lsId) {
        this.lsId = lsId;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void setTournamentStage(TournamentStage tournamentStage) {
        this.tournamentStage = tournamentStage;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}