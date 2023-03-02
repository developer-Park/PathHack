package com.example.pathhack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReceivedCoupon extends TimeStamped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "received_coupon_id")
	private Long id;

	@Column(nullable = false)
	private String couponName;
	@Column(nullable = false)
	private boolean isUsed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public ReceivedCoupon(User user, String couponName) {
		this.couponName = couponName;
		this.user = user;
		this.isUsed = false;
	}

	public void updateIsUsed() {
		this.isUsed = true;
	}
}
