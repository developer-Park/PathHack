package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class CreateEventControllerDTO {
	private final Long userId;
	private final String eventName;

	public CreateEventControllerDTO(CreateEventDTO createEventDTO, Long userId) {
		this.userId = userId;
		this.eventName = createEventDTO.getEventName();
	}
}
