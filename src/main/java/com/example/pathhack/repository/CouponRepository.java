package com.example.pathhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pathhack.entity.Coupon;
import com.example.pathhack.entity.Event;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
	Coupon findByEvent(Event event);
}
