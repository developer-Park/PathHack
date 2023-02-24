package com.example.pathhack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pathhack.entity.ReceivedCoupon;

public interface ReceivedCouponRepository extends JpaRepository<ReceivedCoupon, Long> {
	Optional<ReceivedCoupon> findByIdAndUserId(Long receivedCoupon, Long userId);
}
