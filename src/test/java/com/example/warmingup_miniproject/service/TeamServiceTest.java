package com.example.warmingup_miniproject.service;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.warmingup_miniproject.domain.team.Team;
import com.example.warmingup_miniproject.domain.team.TeamRepository;
import com.example.warmingup_miniproject.dto.team.RequestTeamCreate;
import com.example.warmingup_miniproject.dto.team.ResponseTeamCreate;
import com.example.warmingup_miniproject.exception.TeamAlreadyExistsException;

@SpringBootTest
@Transactional
class TeamServiceTest {

	@Autowired
	TeamRepository teamRepository;
	@Autowired
	private TeamService teamService;

	@Test
	@DisplayName("팀을 생성하는 테스트")
	void createTeamTest() {
		// given
		RequestTeamCreate requestTeamCreate = new RequestTeamCreate("team1");

		// when
		ResponseTeamCreate responseTeamCreate = teamService.createTeam(requestTeamCreate.toEntity());

		// then
		assertThat(responseTeamCreate.id()).isNotNull();
		assertThat(responseTeamCreate.teamName()).isEqualTo("team1");

	}

	@Test
	@DisplayName("팀 이름이 입력되지 않으면 팀 생성은 실패한다.")
	void createTeamFailTest() {
		// given
		Team team1 = new Team("team1");
		teamRepository.save(team1);
		Team team2 = new Team("team1");

		// when then
		assertThatThrownBy(() -> teamService.createTeam(team2))
				.isInstanceOf(TeamAlreadyExistsException.class)
				.hasMessage(ERR_TEAM_ALREADY_EXISTS.name());
	}
}
