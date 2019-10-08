package ru.matchtoday.Controller.Admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matchtoday.Entity.Tournament;
import ru.matchtoday.Parser.LiveScore.Parser;
import ru.matchtoday.Repository.MatchRepository;
import ru.matchtoday.Repository.TeamRepository;
import ru.matchtoday.Repository.TournamentRepository;
import ru.matchtoday.Repository.TournamentStageRepository;

import java.util.List;

@RestController
public class ParseController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentStageRepository tournamentStageRepository;

    @Autowired
    private Parser parser;

    private Logger logger = LoggerFactory.getLogger(ParseController.class);

    @RequestMapping("/admin/parse")
    public String parse() {
        List<Tournament> tournaments = tournamentRepository.findByIsActive(true);

        for (Tournament tournament : tournaments) {
            parser.parseTournament(tournament);
        }

        return "This is admin endpoint!";
    }
}