package com.init.GirlsInTeck.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="address")
public class Address {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_address")
	@Id
	int idAddress;
	@Column(name="street")
	private String street;
	@Column(name="number")
	private int number;
	@Column(name="cp")
	private int cp;
	@Column(name="city")
	private String city;
//	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
//	private Point pointAddress;
	
	
	

}
