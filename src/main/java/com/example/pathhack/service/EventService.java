package com.example.pathhack.service;

import java.util.List;

import com.example.pathhack.dto.CreateEventControllerDTO;
import com.example.pathhack.dto.EventResponse;
import com.example.pathhack.dto.UpdateEventControllerDTO;

public interface EventService {
	List<EventResponse> getEvents();

	void updateEvent(UpdateEventControllerDTO updateEventControllerDTO);

	void createEvent(CreateEventControllerDTO createEventController);
}
