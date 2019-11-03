package ru.matchtoday.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.matchtoday.Entity.Match;
import ru.matchtoday.Entity.Tournament;
import ru.matchtoday.Repository.MatchRepository;
import ru.matchtoday.Repository.TournamentRepository;
import ru.matchtoday.Search.MatchDateSpecifications;
import ru.matchtoday.Search.MatchTournamentSpecifications;
import ru.matchtoday.Search.SearchCriteria;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MatchesController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    private Logger logger = LoggerFactory.getLogger(MatchesController.class);

    @RequestMapping("/matches")
    public List<Match> index(
        @RequestParam String from,
        @RequestParam String to,
        @RequestParam(required = false) String tournaments
    ) {
        return matchRepository.findAll(buildSpecifications(from, to, tournaments));
    }

    private Specification<Match> buildSpecifications(String from, String to, @Nullable String tournaments) {
        MatchDateSpecifications specFrom = new MatchDateSpecifications(
            new SearchCriteria("datetime", ">", from)
        );

        MatchDateSpecifications specTo = new MatchDateSpecifications(
            new SearchCriteria("datetime", "<", to)
        );

        Specification<Match> spec = Specification.where(specFrom);
        spec = spec.and(specTo);

        if (tournaments != null) {
            List<Long> tournamentIds = Stream.of(tournaments.split(",")).map(Long::parseLong).collect(Collectors.toList());
            List<Tournament> TournamentsEntities = tournamentRepository.findByIdIn(tournamentIds);

            MatchTournamentSpecifications tournamentIn = new MatchTournamentSpecifications(TournamentsEntities);

            spec = spec.and(tournamentIn);
        }

        return spec;
    }
}