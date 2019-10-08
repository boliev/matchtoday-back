package ru.matchtoday.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matchtoday.Entity.Tournament;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByIsActive(boolean isActive);
}