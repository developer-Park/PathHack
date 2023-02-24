package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class CreateCouponControllerDTO {
	private final Long userId;
	private final Long eventId;
	private final String couponName;

	public CreateCouponControllerDTO(CreateCouponDTO createCouponDTO, Long userId,Long eventId) {
		this.userId = userId;
		this.couponName = createCouponDTO.getCouponName();
		this.eventId = eventId;
	}
}
