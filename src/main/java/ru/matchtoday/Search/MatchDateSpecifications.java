package ru.matchtoday.Search;

import org.springframework.data.jpa.domain.Specification;
import ru.matchtoday.Entity.Match;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;

public class MatchDateSpecifications
    implements Specification<Match> {

    private SearchCriteria criteria;

    public MatchDateSpecifications(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
        (Root<Match> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        Timestamp value = Timestamp.valueOf(criteria.getValue());

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                root.get(criteria.getKey()), value
            );
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                root.get(criteria.getKey()), value
            );
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            return builder.equal(root.get(criteria.getKey()), value);
        }
        return null;
    }
}