package com.init.GirlsInTeck.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User{

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Id 
	private int id;
	
	@Column(name = "password", unique = true)
	private String password;
	
	
	@Column(name = "email", unique = true)
	private String email;



}
