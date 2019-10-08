package ru.matchtoday.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matchtoday.Entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByLsId(String lsId);
}