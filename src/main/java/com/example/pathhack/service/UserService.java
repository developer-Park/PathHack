package com.example.pathhack.service;

import java.io.IOException;

import com.example.pathhack.dto.CreateUserDTO;
import com.example.pathhack.dto.GetUserDTO;
import com.example.pathhack.dto.UserResponse;

public interface UserService {
	UserResponse getUser(GetUserDTO getUserDTO);

	void addGrapeCount() throws IOException;

	void createUser(CreateUserDTO createUser);

}
