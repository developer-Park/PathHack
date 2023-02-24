package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class ReceivedCouponDTO {
	private final Long userId;
	private final Long couponId;

	public ReceivedCouponDTO(Long userId, Long couponId) {
		this.userId = userId;
		this.couponId = couponId;
	}
}
