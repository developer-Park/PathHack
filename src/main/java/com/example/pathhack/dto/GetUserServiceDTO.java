package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class GetUserServiceDTO {

	private final Long userId;
	private final String kidName;
	private final String parentName;
	private final int grapeCount;

	public GetUserServiceDTO(Long userId, String kidName,String parentName, int grapeCount) {
		this.userId = userId;
		this.kidName = kidName;
		this.parentName = parentName;
		this.grapeCount = grapeCount;
	}
}
