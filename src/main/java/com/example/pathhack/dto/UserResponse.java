package com.example.pathhack.dto;

import com.example.pathhack.entity.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class UserResponse {
	private final Long userId;
	private final String kidName;
	private final String parentName;
	private final int grapeCount;
	public UserResponse(GetUserServiceDTO getUserServiceDTO) {
		this.userId = getUserServiceDTO.getUserId();
		this.kidName = getUserServiceDTO.getKidName();
		this.parentName = getUserServiceDTO.getParentName();
		this.grapeCount = getUserServiceDTO.getGrapeCount();
	}
}
