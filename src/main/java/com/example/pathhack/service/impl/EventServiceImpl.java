package com.example.pathhack.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pathhack.dto.CreateEventControllerDTO;
import com.example.pathhack.dto.EventResponse;
import com.example.pathhack.dto.GetCouponResponse;
import com.example.pathhack.dto.UpdateEventControllerDTO;
import com.example.pathhack.entity.Coupon;
import com.example.pathhack.entity.Event;
import com.example.pathhack.entity.User;
import com.example.pathhack.repository.CouponRepository;
import com.example.pathhack.repository.EventRepository;
import com.example.pathhack.repository.UserRepository;
import com.example.pathhack.service.EventService;
import com.example.pathhack.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {
	private final CouponRepository couponRepository;
	private final EventRepository eventRepository;
	private final UserRepository userRepository;


	@Transactional(readOnly = true)
	@Override
	public List<EventResponse> getEvents() {
		return eventRepository.findAll().stream()
			.map(EventResponse::new)
			.collect(Collectors.toList());
	}

	@Override
	public void updateEvent(UpdateEventControllerDTO updateEventControllerDTO) {
		Event event = eventRepository.findById(updateEventControllerDTO.getEventId())
			.orElseThrow(() -> new IllegalArgumentException("이벤트가 존재하지 않습니다."));
		event.updateEvent(updateEventControllerDTO.getEventName());
		Coupon coupon = couponRepository.findByEvent(event);
		coupon.updateCoupon(updateEventControllerDTO.getEventName());
	}

	@Override
	public void createEvent(CreateEventControllerDTO createEventController) {
		User user  = userRepository.findById(createEventController.getUserId())
			.orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
		Event event = new Event(createEventController.getEventName(),user);
		eventRepository.save(event);
		Coupon coupon = new Coupon(createEventController.getEventName(), user,event);
		couponRepository.save(coupon);
	}

}
