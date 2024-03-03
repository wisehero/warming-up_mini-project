package com.example.warmingup_miniproject.domain.employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	int countEmployeesByTeamId(Long teamId);

	boolean existsByTeamIdAndRole(Long teamId, Role role);

	@Query("select e from Employee  e where e.team.id = :teamId And e.role = 'Manager'")
	Optional<Employee> findManagerByTeamId(@Param("teamId") Long teamId);
}
