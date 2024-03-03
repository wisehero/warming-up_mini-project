package com.example.warmingup_miniproject.domain.attendance;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	@Query("SELECT a FROM Attendance a where a.employee.id = :employeeId "
			+ "AND a.getOffWorkTime IS NOT NULL "
			+ "AND DATE(a.goToWorkTime) BETWEEN :startOfMonth AND :endOfMonth ORDER BY a.goToWorkTime")
	List<Attendance> findAttendanceByEmployeeId(
			@Param("employeeId") Long employeeId,
			@Param("startOfMonth") LocalDate startOfMonth,
			@Param("endOfMonth") LocalDate endOfMonth);

	@Query("SELECT a "
			+ "FROM Attendance a "
			+ "WHERE a.employee.id = :employeeId AND DATE(a.goToWorkTime) = :today")
	Optional<Attendance> findAttendedEmployee(@Param("employeeId") Long employeeId, @Param("today") LocalDate today);

}
