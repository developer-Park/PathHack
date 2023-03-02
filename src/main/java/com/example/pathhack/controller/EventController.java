package com.example.pathhack.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pathhack.dto.CreateEventControllerDTO;
import com.example.pathhack.dto.CreateEventDTO;
import com.example.pathhack.dto.UpdateEventControllerDTO;
import com.example.pathhack.dto.UpdateEventDTO;
import com.example.pathhack.service.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EventController {
	private final EventService eventService;

	@GetMapping("/event")
	public ModelAndView getEvents(Model model) {
		model.addAttribute("events", eventService.getEvents());
		model.addAttribute("UpdateEventDTO", new UpdateEventDTO());
		model.addAttribute("CreateEventDTO", new CreateEventDTO());

		return new ModelAndView("/admin/event-list");
	}

	@PostMapping("/event/user/{userId}")
	public void createEvent(@ModelAttribute CreateEventDTO createEventDTO, @PathVariable Long userId) {
		CreateEventControllerDTO createEventController = new CreateEventControllerDTO(createEventDTO, userId);
		eventService.createEvent(createEventController);
	}

	@PutMapping("/event/{eventId}")
	public void updateEvent(@ModelAttribute UpdateEventDTO updateEventDTO, @PathVariable Long eventId) {
		UpdateEventControllerDTO updateEventControllerDTO = new UpdateEventControllerDTO(updateEventDTO, eventId);
		eventService.updateEvent(updateEventControllerDTO);
	}

}
