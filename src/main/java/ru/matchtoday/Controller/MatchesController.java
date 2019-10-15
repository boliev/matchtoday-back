package ru.matchtoday.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.matchtoday.Entity.Match;
import ru.matchtoday.Repository.MatchRepository;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class MatchesController {

    @Autowired
    private MatchRepository matchRepository;

    private Logger logger = LoggerFactory.getLogger(MatchesController.class);

    @RequestMapping("/matches")
    public List<Match> index(@RequestParam String from, @RequestParam String to) {
        Timestamp fromTimestamp = Timestamp.valueOf(from);
        Timestamp toTimestamp = Timestamp.valueOf(to);

        return matchRepository.findByDatetimeBetween(fromTimestamp, toTimestamp);
    }
}