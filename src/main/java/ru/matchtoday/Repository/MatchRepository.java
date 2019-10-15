package ru.matchtoday.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matchtoday.Entity.Match;

import java.sql.Timestamp;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByHomeTeam(String homeTeam);

    Match findByLsId(String lsId);

    List<Match> findByDatetimeBetween(Timestamp from, Timestamp to);
}