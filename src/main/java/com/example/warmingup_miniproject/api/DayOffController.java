package com.example.warmingup_miniproject.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.warmingup_miniproject.dto.dayoff.request.RequestDayOffCreate;
import com.example.warmingup_miniproject.dto.dayoff.response.ResponseDayOffCreate;
import com.example.warmingup_miniproject.service.DayOffService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dayOffs")
@RequiredArgsConstructor
public class DayOffController {

	private final DayOffService dayOffService;

	@PostMapping
	public ResponseDayOffCreate applyDayOff(@RequestBody RequestDayOffCreate request) {
		return dayOffService.applyDayOff(request);
	}
}
