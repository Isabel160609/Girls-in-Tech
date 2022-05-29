package com.init.GirlsInTeck.service;

import java.util.List;
import java.util.Optional;

import com.init.GirlsInTeck.dto.UserDto;
import com.init.GirlsInTeck.entity.User;

public interface IServiceUser {
	List<User> listUsers();
	User createUser(UserDto userDto);
	String DeleteUser(int id);
	Optional<User> getUser(String username);
	String updateUser(int id, UserDto UserDto);
	
}
