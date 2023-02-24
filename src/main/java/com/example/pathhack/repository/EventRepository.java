package com.example.pathhack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pathhack.entity.Coupon;
import com.example.pathhack.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	Optional<Event> findByIdAndUserId(Long eventId,Long userId);
}
