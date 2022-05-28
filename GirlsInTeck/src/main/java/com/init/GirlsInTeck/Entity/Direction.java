package com.init.GirlsInTeck.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="direction")
public class Direction {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_direction")
	int id;
	@Column(name="street")
	private String street;
	@Column(name="number")
	private int number;
	@Column(name="cp")
	private int cp;
	@Column(name="city")
	private String city;
	@OneToOne(mappedBy = "direction", cascade = CascadeType.ALL)
	private Point point;
	
	
	

}
