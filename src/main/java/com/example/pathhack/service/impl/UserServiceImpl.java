package com.example.pathhack.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pathhack.dto.CreateUserDTO;
import com.example.pathhack.dto.GetUserDTO;
import com.example.pathhack.dto.GetUserServiceDTO;
import com.example.pathhack.dto.UserResponse;
import com.example.pathhack.entity.User;
import com.example.pathhack.repository.UserRepository;
import com.example.pathhack.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
@EnableScheduling
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	@Scheduled(cron = "0 0 23 * * ?")
	public void addGrapeCount() throws IOException {
		User user = userRepository.findById(1L)
			.orElseThrow(() -> new IllegalArgumentException("user does not exist."));
		BufferedReader reader = new BufferedReader(new FileReader("c:\\pathhack\\HardwareData.txt"));
		BufferedWriter backup = new BufferedWriter(new FileWriter("c:\\pathhack\\Backup.txt", true));
		String ch;
		int brushCount = 0;
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// 포맷 적용
		String formatedNow = now.format(formatter);

		while ((ch = reader.readLine()) != null) {
			String ch1 = ch;
			//Arduino's test1.txt file make one enter each line.
			//2023-02-25 11:08:53 248
			//
			//2023-02-25 11:08:36 249
			//
			//2023-02-25 11:08:53 248
			//
			//2023-02-25 11:08:53 248
			if (ch1.isEmpty()) {
				continue;
			}
			//backup data
			backup.write("\n");
			backup.write(ch1);
			backup.flush();
			//formatedNow == yyyy-MM-DD
			if (Integer.parseInt(ch.substring(20)) >= 200 && ch1.substring(0, 10).equals(formatedNow)) {
				brushCount++;
			}
		}
		//if kids brushed their teeth over three time a day, they will get a one grape coupon.
		if (brushCount >= 3) {
			user.updateGrapeCount();

			//reset data everyday
			try (FileOutputStream fos = new FileOutputStream("c:\\pathhack\\HardwareData.txt", false)) {
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		reader.close();
	}

	@Override
	public UserResponse getUser(GetUserDTO getUserDTO) {
		User user = userRepository.findById(getUserDTO.getUserId())
			.orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
		GetUserServiceDTO getUserServiceDTO = new GetUserServiceDTO(user.getId(), user.getKidName(),
			user.getParentName(),
			user.getGrapeCount());
		return new UserResponse(getUserServiceDTO);
	}

	@Override
	public void createUser(CreateUserDTO createUser) {
		User user = new User(createUser);
		userRepository.save(user);
	}
}