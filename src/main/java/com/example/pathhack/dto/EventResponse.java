package com.example.pathhack.dto;

import java.time.LocalDateTime;

import com.example.pathhack.entity.Event;

import lombok.Getter;

@Getter
public class EventResponse {
	private final Long eventId;
	private final String eventName;

	private final LocalDateTime createdTime;
	private final LocalDateTime updatedTime;

	public EventResponse(Event event) {
		this.eventId = event.getId();
		this.eventName = event.getEventName();
		this.createdTime = event.getCreatedDate();
		this.updatedTime = event.getModifiedDate();
	}
}
