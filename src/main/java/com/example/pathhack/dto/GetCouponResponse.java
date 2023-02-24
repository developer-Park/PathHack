package com.example.pathhack.dto;

import java.time.LocalDateTime;

import com.example.pathhack.entity.Coupon;

import lombok.Getter;

@Getter
public class GetCouponResponse {
	private final Long couponId;
	private final String couponName;
	private final Boolean isUsed;

	private final LocalDateTime createdTime;
	private final LocalDateTime updatedTime;

	public GetCouponResponse(Coupon coupon) {
		this.couponId = coupon.getId();
		this.couponName = coupon.getCouponName();
		this.isUsed = coupon.isUsed();
		this.createdTime = coupon.getCreatedDate();
		this.updatedTime = coupon.getModifiedDate();
	}
}
