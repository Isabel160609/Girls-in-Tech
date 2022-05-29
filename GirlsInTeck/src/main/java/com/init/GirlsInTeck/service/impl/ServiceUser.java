package com.init.GirlsInTeck.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.GirlsInTeck.dto.UserDto;
import com.init.GirlsInTeck.entity.User;
import com.init.GirlsInTeck.repository.UserRepository;
import com.init.GirlsInTeck.service.IServiceUser;



@Service
public class ServiceUser implements IServiceUser{

	@Autowired
	private UserRepository userRepository;

	// 1 List user
	public List<User> listUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	// 2 create user
	public User createUser(UserDto userDto) {
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		userRepository.save(user);
		return user;
	}

	// 3 Delete User
	public String DeleteUser(int id) {
		String response;
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isEmpty()) {
			User userForDelete=user.get();
			userRepository.delete(userForDelete);
			response = "User deleted";
		} else {
			response = "this user already exist";
		}
		return response;
	}

	// 4 find user

	public Optional<User> getUser(String userName) {

		Optional<User> Optionaluser = userRepository.findByUsername(userName);
		return Optionaluser;

	}

	// 5 update user
	public String updateUser(int id, UserDto UserDto) {
		String response;
		Optional<User> Optionaluser = userRepository.findById(id);
		if (!Optionaluser.isEmpty()) {
			User updateuser = Optionaluser.get();
			updateuser.setEmail(UserDto.getEmail());
			updateuser.setUsername(UserDto.getUsername());
			userRepository.save(updateuser);
			response = "this user is already updated";
		} else {
			response = "this user exist";
		}
		return response;
	}

}
