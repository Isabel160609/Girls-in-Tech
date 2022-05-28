package com.init.GirlsInTeck.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User{

	@Id 
	private long id;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "email", unique = true)
	private String email;



}
