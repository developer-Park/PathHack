package com.example.pathhack.dto;

import lombok.Getter;

@Getter
public class GrapeResponse {
	private final Long grapeCount;

	public GrapeResponse(Long grapeCount) {
		this.grapeCount = grapeCount;
	}
}
