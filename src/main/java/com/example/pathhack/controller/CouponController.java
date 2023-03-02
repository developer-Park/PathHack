package com.example.pathhack.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pathhack.dto.CreateCouponControllerDTO;
import com.example.pathhack.dto.CreateCouponDTO;
import com.example.pathhack.dto.ReceivedCouponDTO;
import com.example.pathhack.dto.UseTheCouponDTO;
import com.example.pathhack.service.CouponService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CouponController {
	private final CouponService couponService;

	@GetMapping("/coupon")
	public ModelAndView getCoupon(Model model) {
		model.addAttribute("coupons", couponService.getCoupons());
		return new ModelAndView("/admin/coupon-list");
	}

	@GetMapping("/received-coupon")
	public ModelAndView getReceivedCoupon(Model model) {
		model.addAttribute("coupons", couponService.getReceivedCoupons());
		return new ModelAndView("/admin/received-coupon-list");
	}

	@PostMapping("/user/{userId}/event/{eventId}/coupon")
	public void createCoupon(@RequestBody CreateCouponDTO createCouponDTO, @PathVariable Long userId,
		@PathVariable Long eventId) {
		CreateCouponControllerDTO createCouponControllerDTO = new CreateCouponControllerDTO(createCouponDTO, userId,
			eventId);
		couponService.createCoupon(createCouponControllerDTO);
	}

	@PostMapping("/coupon/user/{couponId}")
	public void receivedCoupon(@PathVariable Long couponId, Model model) {
		ReceivedCouponDTO receivedCouponDTO = new ReceivedCouponDTO(couponId);
		couponService.receivedCoupon(receivedCouponDTO);
	}

	@PutMapping("/coupon/user/use/{received_couponId}")
	public void useTheCoupon(@PathVariable Long received_couponId, Model model) {
		UseTheCouponDTO useTheCouponDTO = new UseTheCouponDTO(received_couponId);
		couponService.useTheCoupon(useTheCouponDTO);
		model.addAttribute("message", "사용완료");
		model.addAttribute("searchUrl", "/api/coupon");

	}
}
