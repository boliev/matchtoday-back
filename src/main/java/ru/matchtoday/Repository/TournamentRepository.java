package ru.matchtoday.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matchtoday.Entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}