package ru.matchtoday.Parser.LiveScore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.matchtoday.Entity.Match;
import ru.matchtoday.Entity.Team;
import ru.matchtoday.Entity.Tournament;
import ru.matchtoday.Entity.TournamentStage;
import ru.matchtoday.Parser.DTO.MatchDto;
import ru.matchtoday.Parser.DTO.TeamDto;
import ru.matchtoday.Repository.MatchRepository;
import ru.matchtoday.Repository.TeamRepository;
import ru.matchtoday.Repository.TournamentStageRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class Parser {

    @Autowired
    private Client client;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TournamentStageRepository tournamentStageRepository;

    private HashMap<String, Team> cachedTeams = new HashMap<String, Team>();
    private HashMap<String, TournamentStage> cachedStages = new HashMap<String, TournamentStage>();

    public void parseTournament(Tournament tournament) {
        List<MatchDto> matches = client.getTournamentMatches(tournament.getLsId());
        for (int i = 0; i < matches.size(); i++) {
            MatchDto matchDto = matches.get(i);
            Team homeTeam = getTeam(matchDto.getHomeTeam(), tournament.getCountry());
            Team awayTeam = getTeam(matchDto.getAwayTeam(), tournament.getCountry());
            TournamentStage stage = getStage(matchDto.getStage(), tournament);
            createOrUpdateMatch(matchDto, homeTeam, awayTeam, tournament, stage);
        }
    }

    private Match createOrUpdateMatch(MatchDto matchDto, Team homeTeam, Team awayTeam, Tournament tournament, TournamentStage stage) {
        Match match = matchRepository.findByLsId(matchDto.getId());
        if (match == null) {
            match = new Match();
        }

        LocalDateTime date = LocalDateTime.parse(matchDto.getDate() + "T" + matchDto.getTime());
        match.setHomeTeam(homeTeam);
        match.setGuestTeam(awayTeam);
        match.setLsId(matchDto.getId());
        match.setTournament(tournament);
        match.setTournamentStage(stage);
        match.setDatetime(Timestamp.valueOf(date));
        matchRepository.save(match);

        return match;
    }

    private Team getTeam(TeamDto teamDto, String country) {
        if (cachedTeams.containsKey(teamDto.getId())) {
            return cachedTeams.get(teamDto.getId());
        }

        Team team = teamRepository.findByLsId(teamDto.getId());

        if (team == null) {
            team = createTeam(teamDto, country);
        }

        cachedTeams.put(teamDto.getId(), team);

        return team;
    }

    private Team createTeam(TeamDto teamDto, String country) {
        Team team = new Team(teamDto.getName(), country);
        team.setLsId(teamDto.getId());

        teamRepository.save(team);

        return team;
    }

    private TournamentStage getStage(String stageName, Tournament tournament) {
        String stageKey = tournament.getId().toString() + stageName;

        if (cachedStages.containsKey(stageKey)) {
            return cachedStages.get(stageKey);
        }

        TournamentStage stage = tournamentStageRepository.findByNameAndTournament(stageName, tournament);
        if (stage == null) {
            stage = new TournamentStage(stageName, tournament);
            tournamentStageRepository.save(stage);
        }

        cachedStages.put(stageKey, stage);

        return stage;
    }

}
