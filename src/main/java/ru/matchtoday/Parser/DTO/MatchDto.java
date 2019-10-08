package ru.matchtoday.Parser.DTO;

public class MatchDto {
    private String id;
    private String date;
    private String time;
    private String stage;
    private TeamDto homeTeam;
    private TeamDto awayTeam;
    private String tournamentId;

    public MatchDto(String id, String date, String time, String stage, TeamDto homeTeam, TeamDto awayTeam, String tournamentId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.stage = stage;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.tournamentId = tournamentId;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStage() {
        return stage;
    }

    public TeamDto getHomeTeam() {
        return homeTeam;
    }

    public TeamDto getAwayTeam() {
        return awayTeam;
    }

    public String getTournamentId() {
        return tournamentId;
    }
}
