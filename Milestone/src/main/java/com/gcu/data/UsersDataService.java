package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UsersDataService {

	@Autowired
	private UsersRepository usersRepository;

	public UserEntity findByUsername(String username) {

		return usersRepository.findByUsername(username);
	}

}
