package com.example.pathhack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pathhack.entity.ReceivedCoupon;

public interface ReceivedCouponRepository extends JpaRepository<ReceivedCoupon, Long> {
}
