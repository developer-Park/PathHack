package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class GetUserDTO {
	private final Long userId;

	public GetUserDTO(Long userId) {
		this.userId = userId;
	}
}
