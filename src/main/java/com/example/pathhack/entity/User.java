package com.example.pathhack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.pathhack.dto.CreateUserDTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends TimeStamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(nullable = false)
	private String kidName;

	@Column(nullable = false)
	private String parentName;

	@Column(nullable = false)
	private int grapeCount;

	public User(CreateUserDTO createUserDTO) {
		this.kidName = createUserDTO.getKidName();
		this.parentName = createUserDTO.getParentName();
		this.grapeCount = 0;
	}

	public void updateGrapeCount() {
		this.grapeCount++;
	}
}

