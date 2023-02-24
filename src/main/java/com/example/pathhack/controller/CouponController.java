package com.example.pathhack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathhack.dto.CreateCouponControllerDTO;
import com.example.pathhack.dto.CreateCouponDTO;
import com.example.pathhack.dto.GetCouponResponse;
import com.example.pathhack.dto.GetUserDTO;
import com.example.pathhack.dto.ReceivedCouponDTO;
import com.example.pathhack.dto.UserResponse;
import com.example.pathhack.service.CouponService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CouponController {
	private final CouponService couponService;

	@GetMapping("/coupon")
	public List<GetCouponResponse> getCoupon() {
		return couponService.getCoupons();
	}
	@PostMapping("/user/{userId}/event/{eventId}/coupon")
	public void createCoupon(@RequestBody CreateCouponDTO createCouponDTO, @PathVariable Long userId,
		@PathVariable Long eventId) {
		CreateCouponControllerDTO createCouponControllerDTO = new CreateCouponControllerDTO(createCouponDTO,userId,eventId);
		couponService.createCoupon(createCouponControllerDTO);
	}

	@PostMapping("/coupon/{couponId}/user/{userId}")
	public void receivedCoupon(@PathVariable Long couponId, @PathVariable Long userId) {
		ReceivedCouponDTO receivedCouponDTO = new ReceivedCouponDTO(couponId,userId);
		couponService.receivedCoupon(receivedCouponDTO);
	}
	//
	// @PutMapping("/coupon/{couponId}/user/{userId}")
	// public void receivedCoupon(@PathVariable Long couponId, @PathVariable Long userId) {
	// 	ReceivedCouponDTO receivedCouponDTO = new ReceivedCouponDTO(couponId,userId);
	// 	couponService.receivedCoupon(receivedCouponDTO);
	// }
}
