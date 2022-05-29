package com.init.GirlsInTeck.dto;

import com.init.GirlsInTeck.entity.Location;
import com.init.GirlsInTeck.enums.Color;
import com.init.GirlsInTeck.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PointDto {

	private Location location;
	
	private String activity;
	
	private int radio;

	private String name;

	private Address address;
	
	private Color color;

	private boolean verified;
	
	private String why;
	
	public String toString() {
		return "Point [location=" + location + ", activity=" + activity + ", name=" + name
				+ ", direction=" + address + ", color=" + color + "]";
	
	}
	
	
}
