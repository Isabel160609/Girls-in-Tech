package com.init.GirlsInTeck.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.*;



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
	@Column(name="id")
	@Id
	private int id;
	@OneToOne
	@JoinColumn(name = "point_location", updatable = false, nullable = false)
	private Location location;
	@Column(name="activity")
	private String activity;
	@Column(name="radio")
	private int radio;
	@Column(name="name")
	private String name;
	@OneToOne
	@JoinColumn(name = "point_address", updatable = false, nullable = false)
	private Address address;
	@Column(name="color")
	private Color color;
	@Column(name="verified")
	private boolean verified;
	@Column(name="why")
	private String why;
	@Override
	public String toString() {
		return "Point [id=" + id + ", location=" + location + ", activity=" + activity + ", name=" + name
				+ ", direction=" + address + ", color=" + color + "]";
	}
	public Point(String activity, String name, Address direction, Color color, boolean verified, String why) {
		this.activity = activity;
		this.name = name;
		this.address = direction;
		this.color = color;
		this.verified = verified;
		this.why = why;
	}
	public Point(Location location, String activity, String name, Address direction, Color color, boolean verified) {
		this.location = location;
		this.activity = activity;
		this.name = name;
		this.address = direction;
		this.color = color;
		this.verified = verified;
	}
	
	
	
}
