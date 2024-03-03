package com.example.warmingup_miniproject.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warmingup_miniproject.dto.employee.RequestEmployeeCreate;
import com.example.warmingup_miniproject.dto.employee.ResponseEmployeeCreate;
import com.example.warmingup_miniproject.dto.employee.ResponseEmployeeInfo;
import com.example.warmingup_miniproject.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@PostMapping
	public ResponseEmployeeCreate createEmployee(@RequestBody @Valid RequestEmployeeCreate request) {
		return employeeService.createEmployee(request);
	}

	@GetMapping
	public List<ResponseEmployeeInfo> getMembers() {
		return employeeService.findAllEmployee();
	}

}
