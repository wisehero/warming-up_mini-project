package com.example.warmingup_miniproject.domain.dayoff;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DayOffRepository extends JpaRepository<DayOff, Long> {

	@Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM DayOff d WHERE d.employee.id = :employeeId AND d.dayOffDate = :applyDate")
	boolean isAlreadyAppliedDayOff(@Param("employeeId") Long employeeId, @Param("applyDate") LocalDate applyDate);

	@Query("SELECT d FROM DayOff d WHERE d.employee.id = :employeeId AND d.dayOffDate BETWEEN :startOfMonth AND :endOfMonth")
	List<DayOff> findDayOffTakenByEmployeeAndMonth(
			@Param("employeeId") Long employeeId,
			@Param("startOfMonth") LocalDate startOfMonth,
			@Param("endOfMonth") LocalDate endOfMonth
	);
}
