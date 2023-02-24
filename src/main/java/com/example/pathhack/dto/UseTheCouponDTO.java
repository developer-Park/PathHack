package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class UseTheCouponDTO {
	private final Long userId;
	private final Long receivedCoupon;

	public UseTheCouponDTO(Long userId, Long receivedCoupon) {
		this.userId = userId;
		this.receivedCoupon = receivedCoupon;
	}
}
