package com.example.pathhack.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pathhack.dto.CreateUserDTO;
import com.example.pathhack.dto.GetUserDTO;
import com.example.pathhack.dto.UserResponse;
import com.example.pathhack.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

	private final UserService userService;


	@PostMapping("/user/dummy")
	public void addGrapeCount() throws IOException {
		userService.addGrapeCount();
	}
	@GetMapping("/user/{userId}")
	public UserResponse getUser(@PathVariable Long userId) {
		GetUserDTO getUserDTO = new GetUserDTO(userId);
		return userService.getUser(getUserDTO);
	}
	@PostMapping("/user")
	public void createUser(@RequestBody CreateUserDTO createUser) {
		userService.createUser(createUser);
	}



}
