package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class UpdateEventControllerDTO {
	private final Long eventId;
	private final String eventName;


	public UpdateEventControllerDTO(UpdateEventDTO updateEventDTO, Long eventId) {
		this.eventId = eventId;
		this.eventName = updateEventDTO.getEventName();
	}
}
