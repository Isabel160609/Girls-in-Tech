package com.init.GirlsInTeck.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.domain.Sort.Direction;

import com.init.GirlsInTeck.enums.Color;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="point")
public class Point {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_point")
	private int id;
	@Column(name="location")
	@OneToOne
	@JoinColumn(name = "point", updatable = false, nullable = false)
	private Location location;
	@Column(name="activity")
	private String activity;
	@Column(name="name")
	private String name;
	@Column(name="direction")
	@OneToOne
	@JoinColumn(name = "point", updatable = false, nullable = false)
	private Direction direction;
	@Column(name="color")
	private Color color;
	
}
