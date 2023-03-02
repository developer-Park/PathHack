package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class UseTheCouponDTO {
	private final Long receivedCoupon;

	public UseTheCouponDTO( Long receivedCoupon) {
		this.receivedCoupon = receivedCoupon;
	}
}
