package ru.matchtoday.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.matchtoday.Entity.Match;

public interface MatchRepository extends JpaRepository<Match, Long>, JpaSpecificationExecutor<Match> {
    
    Match findByLsId(String lsId);
}