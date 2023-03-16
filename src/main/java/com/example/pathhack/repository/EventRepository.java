package com.example.pathhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pathhack.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
