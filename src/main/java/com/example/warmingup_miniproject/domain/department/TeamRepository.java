package com.example.warmingup_miniproject.domain.department;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

	Optional<Team> findByTeamName(String teamName);

	boolean existsTeamByTeamName(String name);

}
