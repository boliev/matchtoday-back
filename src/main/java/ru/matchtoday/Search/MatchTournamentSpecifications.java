package ru.matchtoday.Search;

import org.springframework.data.jpa.domain.Specification;
import ru.matchtoday.Entity.Match;
import ru.matchtoday.Entity.Tournament;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MatchTournamentSpecifications
    implements Specification<Match> {

    private List<Tournament> tournaments;

    public MatchTournamentSpecifications(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public Predicate toPredicate
        (Root<Match> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        CriteriaBuilder.In<Tournament> inClause = builder.in(root.get("tournament"));

        for (Tournament tournament : tournaments) {
            inClause.value(tournament);
        }

        return inClause;
    }
}