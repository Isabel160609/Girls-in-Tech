package com.init.GirlsInTeck.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.GirlsInTeck.dto.UserDto;
import com.init.GirlsInTeck.entity.User;
import com.init.GirlsInTeck.service.impl.ServiceUser;




@RestController
@RequestMapping("/")
public class ControllerUser {

	@Autowired
	private ServiceUser service = new ServiceUser();
	
	// 1 List Users return list of Users
		// (GET /users/).
		@GetMapping(value = "/users")
		public ResponseEntity<List<User>> getUsers() {
			try {
				List<User> users = service.listUsers();
				return new  ResponseEntity<List<User>>(users, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.CHECKPOINT);
			}
			
		}

		// 2 POST: /user : create User
		@PostMapping(value = "/user")
		public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
			try {
				User newUser = service.createUser(userDto);
				return new ResponseEntity<>(newUser, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>( HttpStatus.CONFLICT);
			}
			
		}

		// 3 Delete:/user /{username}:Delete User
		@DeleteMapping(value = "/user/{id}")
		public ResponseEntity<String> deleteUser(@PathVariable int id) {
			try {
				String response = service.DeleteUser(id);
				return new ResponseEntity<String>(response,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
		}

		// 4 Get/user/{username}: buscar usuario
		@GetMapping(value = "/users/{email}")
		public ResponseEntity<User> getUser(@PathVariable String email) {
			try {
				
				Optional<User> user = service.getUser(email);
				if(!user.isEmpty()) {
					User userencontrado=user.get();
					return new ResponseEntity<User> (userencontrado,HttpStatus.FOUND);
				}else {
					return new ResponseEntity<> (HttpStatus.NOT_FOUND);
				}
				
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		
		}

		// 5 Post/user/{id}: actualizar usuario
		@PostMapping(value = "/user/{id}")
		public ResponseEntity<String> updateUsers(@PathVariable int id, @RequestBody UserDto userDto) {
			try {
				String response = service.updateUser(id, userDto);

				return new ResponseEntity<String>(response,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
		}
}
