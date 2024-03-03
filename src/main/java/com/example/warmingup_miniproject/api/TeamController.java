package com.example.warmingup_miniproject.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warmingup_miniproject.dto.team.request.RequestTeamCreate;
import com.example.warmingup_miniproject.dto.team.response.ResponseTeamCreate;
import com.example.warmingup_miniproject.dto.team.response.ResponseTeamInfo;
import com.example.warmingup_miniproject.service.TeamService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

	private final TeamService teamService;

	@PostMapping
	public ResponseTeamCreate createTeam(@RequestBody @Valid RequestTeamCreate request) {
		return teamService.createTeam(request.toEntity());
	}

	@GetMapping
	public List<ResponseTeamInfo> getAllTeamInfo() {
		return teamService.findAllTeamInfo();
	}
}
