package com.init.GirlsInTeck.entity;


import javax.persistence.Column;



import org.springframework.data.annotation.Id;


//@Entity
public class User{

	@Id 
	private long id;
	//@Id // {unique, required}
	@Column(name = "username")
	private String username;
	



}
