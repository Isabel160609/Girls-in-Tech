package com.init.GirlsInTeck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.User.Dao.UserDao;
import com.init.User.Model.User;

@Service
public class ServiceUser {

	@Autowired
	private UserDao userDao;

	// 1 Lista los usuarios
	public List<User> listUsers() {
		List<User> jogadors = userDao.findAll();
		return jogadors;
	}

	// 2 crea un usuario
	public User createUser(User user) {
		userDao.save(user);
		return user;
	}

	// 3 Borra un usuario
	public String DeleteUser(String username) {
		String response;
		Optional<User> user = userDao.findById(username);
		
		if (!user.isEmpty()) {
			User userForDelete=user.get();
			userDao.delete(userForDelete);
			response = "Usuario borrado";
		} else {
			response = "este usuario no existe";
		}
		return response;
	}

	// 4 buscar usuario

	public Optional<User> getUser(String username) {

		Optional<User> Optionaluser = userDao.findById(username);
		return Optionaluser;

	}

	// 5 actualizar usuario
	public String updateUser(String username, User user) {
		String response;
		Optional<User> Optionaluser = userDao.findById(username);
		if (!Optionaluser.isEmpty()) {
			User updateuser = Optionaluser.get();
			updateuser.setAge(user.getAge());
			updateuser.setCity(user.getCity());
			updateuser.setUsername(user.getUsername());
			userDao.save(updateuser);
			response = "este usuario ha sio modificado";
		} else {
			response = "este usuario no existe";
		}
		return response;
	}

}
