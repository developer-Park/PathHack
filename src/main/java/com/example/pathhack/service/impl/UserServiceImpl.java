package com.example.pathhack.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pathhack.dto.CreateUserDTO;
import com.example.pathhack.dto.GetUserDTO;
import com.example.pathhack.dto.GetUserServiceDTO;
import com.example.pathhack.dto.UserResponse;
import com.example.pathhack.entity.User;
import com.example.pathhack.repository.CouponRepository;
import com.example.pathhack.repository.EventRepository;
import com.example.pathhack.repository.UserRepository;
import com.example.pathhack.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final CouponRepository couponRepository;
	private final EventRepository eventRepository;
	private final UserRepository userRepository;

	@Override
	public UserResponse getUser(GetUserDTO getUserDTO) {
		User user = userRepository.findById(getUserDTO.getUserId())
			.orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
		GetUserServiceDTO getUserServiceDTO = new GetUserServiceDTO(user.getId(),user.getKidName(),user.getParentName(),
			user.getGrapeCount());
		return new UserResponse(getUserServiceDTO);
	}



	@Override
	public void addGrapeCount() throws IOException {
		User user = userRepository.findById(1L)
			.orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
		FileReader reader = new FileReader("c:\\pathhack\\text.txt");
		int ch;
		while ((ch = reader.read()) != -1) {
			if(ch == 1) {
				user.updateGrapeCount();
			}
		}
	}

	@Override
	public void createUser(CreateUserDTO createUser) {
		User user = new User(createUser);
		userRepository.save(user);

	}
}