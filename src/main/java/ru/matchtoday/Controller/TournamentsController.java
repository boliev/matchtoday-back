package ru.matchtoday.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matchtoday.Entity.Tournament;
import ru.matchtoday.Repository.TournamentRepository;

import java.util.List;

@RestController
public class TournamentsController {

    @Autowired
    private TournamentRepository tournamentRepository;

    private Logger logger = LoggerFactory.getLogger(TournamentsController.class);

    @RequestMapping("/tournaments")
    public List<Tournament> index() {
        return tournamentRepository.findByIsActive(true);
    }
}