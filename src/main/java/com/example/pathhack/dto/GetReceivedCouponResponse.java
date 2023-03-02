package com.example.pathhack.dto;

import java.time.LocalDateTime;

import com.example.pathhack.entity.ReceivedCoupon;

import lombok.Getter;

@Getter
public class GetReceivedCouponResponse {
	private final Long couponId;
	private final String couponName;
	private final Boolean isUsed;

	private final LocalDateTime createdTime;
	private final LocalDateTime updatedTime;

	public GetReceivedCouponResponse(ReceivedCoupon coupon) {
		this.couponId = coupon.getId();
		this.couponName = coupon.getCouponName();
		this.isUsed = coupon.isUsed();
		this.createdTime = coupon.getCreatedDate();
		this.updatedTime = coupon.getModifiedDate();
	}
}
