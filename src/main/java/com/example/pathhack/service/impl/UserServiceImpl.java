package com.example.pathhack.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
		GetUserServiceDTO getUserServiceDTO = new GetUserServiceDTO(user.getId(), user.getKidName(),
			user.getParentName(),
			user.getGrapeCount());
		return new UserResponse(getUserServiceDTO);
	}

	@Override
	public void addGrapeCount() throws IOException {
		User user = userRepository.findById(1L)
			.orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

		BufferedReader reader = new BufferedReader(new FileReader("c:\\pathhack\\text.txt"));

		String ch;
		ArrayList<String>  timeRecord = new ArrayList<>();
		while ((ch = reader.readLine()) != null) {
			//서브0,10의 값이 3이상 그리고 20의값이 1000이상 일때
			timeRecord.add(ch.substring(0, 10));
		}

		ArrayList<String> time = new ArrayList<>();
		for (int i = 0; i < timeRecord.size(); i++) {
			int count =0;
			for(int j=i+1; j< timeRecord.size(); j++) {
				count++;
				if (Objects.equals(timeRecord.get(i), timeRecord.get(j))) {
				}

			}
		}
			/*for(int i=0; i<timeRecord-1; i++){// 자기 자신을 제외한 모든 이름 비교
				for(int j=i+1; j<valueLength; j++){ // 앞에 비교한 이름을 비교하지 않는다.
					if(value[i] == value[j]){
						listA.add(value[i]); // 같으면 추가한다.
			*/
//		reader.close();

	}
	// 	}
	// }
	// return listA;



	// if (Integer.parseInt(ch.substring(20)) >= 1000)
	// 		user.updateGrapeCount();
	// 	brushCount ++;

	// if (brushCount  >= 3)
	// 	break;

	@Override
	public void createUser(CreateUserDTO createUser) {
		User user = new User(createUser);
		userRepository.save(user);

	}
}