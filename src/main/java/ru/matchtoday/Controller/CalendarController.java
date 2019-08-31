package ru.matchtoday.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matchtoday.Entity.Match;
import ru.matchtoday.Repository.MatchRepository;

@RestController
public class CalendarController {

    @Autowired
    private MatchRepository matchRepository;

    private Logger logger = LoggerFactory.getLogger(CalendarController.class);

    @RequestMapping("/")
    public String index() {
        matchRepository.save(new Match("Alania", "Spartak"));
        matchRepository.save(new Match("Zenit", "CSKA"));
        matchRepository.save(new Match("Lokomotiv", "Dinamo"));

        matchRepository.findAll().forEach(match -> {
            logger.info("OK!");
        });

        return "Hey hey hey! This is your calendar maaaaan!";
    }

}