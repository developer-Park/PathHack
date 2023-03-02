package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class ReceivedCouponDTO {
	private final Long couponId;

	public ReceivedCouponDTO(Long couponId) {
		this.couponId = couponId;
	}
}
