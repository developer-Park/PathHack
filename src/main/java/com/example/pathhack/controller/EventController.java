package com.example.pathhack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathhack.dto.CreateEventControllerDTO;
import com.example.pathhack.dto.CreateEventDTO;
import com.example.pathhack.dto.EventResponse;
import com.example.pathhack.dto.UpdateEventControllerDTO;
import com.example.pathhack.dto.UpdateEventDTO;
import com.example.pathhack.service.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EventController {
	private final EventService eventService;
	@GetMapping("/event")
	public List<EventResponse> getEvents() {
		return eventService.getEvents();
	}

	@PostMapping("/event/user/{userId}")
	public void createEvent(@RequestBody CreateEventDTO createEventDTO,@PathVariable Long userId) {
		CreateEventControllerDTO createEventController = new CreateEventControllerDTO(createEventDTO,userId);
		eventService.createEvent(createEventController);
	}

	@PutMapping("/event/{eventId}")
	public void updateEvent(@RequestBody UpdateEventDTO updateEventDTO, @PathVariable Long eventId) {
		UpdateEventControllerDTO updateEventControllerDTO = new UpdateEventControllerDTO(updateEventDTO,eventId);
		eventService.updateEvent(updateEventControllerDTO);
	}

}
