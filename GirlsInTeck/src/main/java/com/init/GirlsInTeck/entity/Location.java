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
@Table(name="location")
public class Location {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_location")
	@Id
	private int id_location;
	@Column(name="x")
	private double x;
	@Column(name="y")
	private double y;
	@OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
	private Point pointLocation;
	
}
