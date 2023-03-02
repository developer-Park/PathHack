package com.example.pathhack.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pathhack.dto.CreateCouponControllerDTO;
import com.example.pathhack.dto.GetCouponResponse;
import com.example.pathhack.dto.GetReceivedCouponResponse;
import com.example.pathhack.dto.ReceivedCouponDTO;
import com.example.pathhack.dto.UseTheCouponDTO;
import com.example.pathhack.entity.Coupon;
import com.example.pathhack.entity.Event;
import com.example.pathhack.entity.ReceivedCoupon;
import com.example.pathhack.entity.User;
import com.example.pathhack.repository.CouponRepository;
import com.example.pathhack.repository.EventRepository;
import com.example.pathhack.repository.ReceivedCouponRepository;
import com.example.pathhack.repository.UserRepository;
import com.example.pathhack.service.CouponService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {
	private final CouponRepository couponRepository;
	private final EventRepository eventRepository;
	private final UserRepository userRepository;

	private final ReceivedCouponRepository receivedCouponRepository;

	@Transactional(readOnly = true)
	@Override
	public List<GetCouponResponse> getCoupons() {
		return couponRepository.findAll().stream()
			.map(GetCouponResponse::new)
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	@Override
	public List<GetReceivedCouponResponse> getReceivedCoupons() {
		return receivedCouponRepository.findAll().stream()
			.map(GetReceivedCouponResponse::new)
			.collect(Collectors.toList());
	}

	@Override
	public void createCoupon(CreateCouponControllerDTO createCouponControllerDTO) {
		User user = userRepository.findById(createCouponControllerDTO.getUserId())
			.orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
		Event event = eventRepository.findById(createCouponControllerDTO.getEventId())
			.orElseThrow(() -> new IllegalArgumentException("이벤트가 존재하지 않습니다."));
		Coupon coupon = new Coupon(createCouponControllerDTO.getCouponName(), user, event);
		couponRepository.save(coupon);
	}

	@Override
	public void receivedCoupon(ReceivedCouponDTO receivedCouponDTO) {
		User user = userRepository.findById(1L)
			.orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
		Coupon coupon = couponRepository.findById(receivedCouponDTO.getCouponId())
			.orElseThrow(() -> new IllegalArgumentException("쿠폰이 존재하지 않습니다."));

		//If they have over 14 grape count, they can get a coupon.
		if (user.getGrapeCount() >= 14 && !coupon.isUsed()) {
			user.minusGrapeCount();
			coupon.updateIsUsed();
			ReceivedCoupon receivedCoupon = new ReceivedCoupon(user, coupon.getCouponName());
			receivedCouponRepository.save(receivedCoupon);
		} else {
			throw new IllegalArgumentException("갯수가 맞지 않습니다.");
		}
	}

	@Override
	public void useTheCoupon(UseTheCouponDTO useTheCouponDTO) {
		ReceivedCoupon receivedCoupon = receivedCouponRepository.findById(useTheCouponDTO.getReceivedCoupon())
			.orElseThrow(() -> new IllegalArgumentException("받은 쿠폰이 존재하지 않습니다."));
		if (receivedCoupon.isUsed()) {
			throw new IllegalArgumentException("사용이 완료된 쿠폰입니다.");
		}
		receivedCoupon.updateIsUsed();

	}
}

