package com.example.pathhack.service;

import java.util.List;

import com.example.pathhack.dto.CreateCouponControllerDTO;
import com.example.pathhack.dto.GetCouponResponse;
import com.example.pathhack.dto.GetReceivedCouponResponse;
import com.example.pathhack.dto.ReceivedCouponDTO;
import com.example.pathhack.dto.UseTheCouponDTO;

public interface CouponService {
	List<GetCouponResponse> getCoupons();

	void createCoupon(CreateCouponControllerDTO createCouponControllerDTO);

	void receivedCoupon(ReceivedCouponDTO receivedCouponDTO);

	void useTheCoupon(UseTheCouponDTO useTheCouponDTO);

	List<GetReceivedCouponResponse> getReceivedCoupons();
}

