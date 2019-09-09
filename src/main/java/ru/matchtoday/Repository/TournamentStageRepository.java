package ru.matchtoday.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.matchtoday.Entity.TournamentStage;

public interface TournamentStageRepository extends JpaRepository<TournamentStage, Long> {
}