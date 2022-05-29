package com.init.GirlsInTeck.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.GirlsInTeck.dto.AddressDto;
import com.init.GirlsInTeck.dto.LocationDto;
import com.init.GirlsInTeck.dto.PointDto;
import com.init.GirlsInTeck.entity.Address;
import com.init.GirlsInTeck.entity.Location;
import com.init.GirlsInTeck.entity.Point;
import com.init.GirlsInTeck.repository.AddressRepository;
import com.init.GirlsInTeck.repository.LocationRepository;
import com.init.GirlsInTeck.repository.PointRepository;

@Service
public class ServicePoint {
	@Autowired
	private ServiceAddress serviceAddress;

	@Autowired
	private ServiceLocation serviceLocation;

	@Autowired
	private PointRepository pointRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private LocationRepository locationRepository;

	// 1 List points

	public List<Point> listPoints() {
		List<Point> points;
		points = pointRepository.findAll();
		return points;
	}

	// 2 create point
	public Point createPoint(PointDto pointDto) {
		Point point = new Point();

		point.setActivity(pointDto.getActivity());
		point.setColor(pointDto.getColor());
		point.setAddress(pointDto.getAddress());
		point.setLocation(pointDto.getLocation());
		point.setName(pointDto.getName());
		point.setWhy(pointDto.getWhy());
		point.setRadio(pointDto.getRadio());
		point.setVerified(pointDto.isVerified());
		point.setWhy(pointDto.getWhy());
		point.setRadio(pointDto.getRadio());
		point.setVerified(pointDto.isVerified());

		Address address = pointDto.getAddress();
		addressRepository.save(address);

		Location location = pointDto.getLocation();
		locationRepository.save(location);

		pointRepository.save(point);

		return point;
	}

	// 3 delete point
	public String deletePointById(int id) {
		String response;
		Optional<Point> point = pointRepository.findById(id);

		if (!point.isEmpty()) {
			Point pointForDelete = point.get();
			pointRepository.delete(pointForDelete);
			response = "deleted point";
		} else {
			response = "this point doesn't exixst";
		}
		return response;
	}

	// 4 saerch point

	public String getPointById(int id) {

		String response;
		Optional<Point> OptionalPoint = pointRepository.findById(id);
		if (!OptionalPoint.isEmpty()) {
			Point pointForGet = OptionalPoint.get();

			response = pointForGet.toString();
		} else {
			response = "this point doesn't exixst";
		}
		return response;

	}

	// 5 update point
	public String updatePoint(int id, PointDto PointDto) {
		String response;
		Optional<Point> Optionalpoint = pointRepository.findById(id);
		if (!Optionalpoint.isEmpty()) {
			Point updatepoint = Optionalpoint.get();
			System.out.println(updatepoint.getAddress().getId_address());
			updatepoint.setActivity(PointDto.getActivity());
			updatepoint.setColor(PointDto.getColor());
			
//			// update address and save
			Address address = addressRepository.findById(updatepoint.getAddress().getId_address()).get();
			AddressDto addressDto = new AddressDto(PointDto.getAddress().getStreet(), PointDto.getAddress().getNumber(), PointDto.getAddress().getCp(),
					PointDto.getAddress().getCity());
			serviceAddress.updateAddress(address.getId_address(), addressDto);
			//updatepoint.setAddress(address);
			//updatepoint.setLocation(PointDto.getLocation());
			Location location=locationRepository.findById(updatepoint.getLocation().getId_location()).get();
			LocationDto locationDto= new LocationDto(PointDto.getLocation().getX(),PointDto.getLocation().getY());
			serviceLocation.updateLocation(location.getId_location(), locationDto);
			updatepoint.setName(PointDto.getName());
			updatepoint.setWhy(PointDto.getWhy());
			updatepoint.setRadio(PointDto.getRadio());
			updatepoint.setVerified(PointDto.isVerified());

			pointRepository.save(updatepoint);
			response = "this point has been modified";
		} else {
			response = "this point doesn't exist";
		}
		return response;
	}
}
