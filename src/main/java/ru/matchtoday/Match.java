package ru.matchtoday;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String homeTeam;
    private String guestTeam;

    protected Match() {
    }

    public Match(String homeTeam, String guestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
    }

    @Override
    public String toString() {
        return String.format(
                "Match[id=%d, homeTeam='%s', guestTeam='%s']",
                id, homeTeam, guestTeam);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
    }
}