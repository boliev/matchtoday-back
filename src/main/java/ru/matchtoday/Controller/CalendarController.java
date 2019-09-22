package ru.matchtoday.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matchtoday.Entity.Match;
import ru.matchtoday.Entity.Team;
import ru.matchtoday.Entity.Tournament;
import ru.matchtoday.Entity.TournamentStage;
import ru.matchtoday.Repository.MatchRepository;
import ru.matchtoday.Repository.TeamRepository;
import ru.matchtoday.Repository.TournamentRepository;
import ru.matchtoday.Repository.TournamentStageRepository;

import java.sql.Timestamp;

@RestController
public class CalendarController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentStageRepository tournamentStageRepository;

    private Logger logger = LoggerFactory.getLogger(CalendarController.class);

    @RequestMapping("/")
    public String index() {
        // This is just test code
        Team alania = createTeam("Alania", "RU", (long) 1306500);
        Team spartak = createTeam("Spartak", "RU", (long) 1306582);
        Team zenit = createTeam("Zenit", "RU", (long) 1306495);
        Team cska = createTeam("CSKA", "RU", (long) 1306500);
        Team lokomotiv = createTeam("Lokomotiv", "RU", (long) 1306527);
        Team dinamo = createTeam("Dinamo", "RU", (long) 1306597);

        Tournament russiaLeague = new Tournament("Russia league");
        russiaLeague.setLsId((long) 7);
        tournamentRepository.save(russiaLeague);
        TournamentStage tur1 = new TournamentStage("Stage 1", russiaLeague);
        tournamentStageRepository.save(tur1);

        matchRepository.save(new Match(alania, spartak, Timestamp.valueOf("2019-09-16 21:00:00"), russiaLeague, tur1));
        matchRepository.save(new Match(zenit, cska, Timestamp.valueOf("2019-09-16 21:00:00"), russiaLeague, tur1));
        matchRepository.save(new Match(lokomotiv, dinamo, Timestamp.valueOf("2019-09-16 21:00:00"), russiaLeague, tur1));

        return "Hey hey hey! This is your calendar maaaaan!";
    }

    private Team createTeam(String name, String country, Long lsId) {
        Team team = new Team(name, country);
        team.setLsId(lsId);
        teamRepository.save(team);
        return team;
    }

}