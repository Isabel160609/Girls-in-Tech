package com.init.GirlsInTeck.service.impl;

import com.init.GirlsInTeck.dto.LocationDto;
import com.init.GirlsInTeck.entity.Location;
import com.init.GirlsInTeck.repository.LocationRepository;
import com.init.GirlsInTeck.service.IServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceLocation implements IServiceLocation {

    @Autowired
    private LocationRepository locationRepository;

    //create
    public Location createLocation(LocationDto locationDto) {

        Location location = new Location();
        location.setX(locationDto.getX());
        location.setY(locationDto.getY());
        //location.setPointLocation(locationDto.getPoint());
        locationRepository.save(location);

        return location;
    }

    //update
    @Override
    public String updateLocation(int id, LocationDto locationDto) {
        
        String response;
        Optional<Location> Optional_location = locationRepository.findById(id);
        if (!Optional_location.isEmpty()) {
            Location updateLocation = Optional_location.get();
            updateLocation.setX(locationDto.getX());
            updateLocation.setY(locationDto.getY());
           // updateLocation.setPointLocation(locationDto.getPoint());

            locationRepository.save(updateLocation);
            response = "this location has been modified";
        } else {
            response = "this location doesn't exist";
        }
        return response;
    }

    //delete
    @Override
    public String deleteLocationById(int id) {
        String response;
        Optional<Location> location = locationRepository.findById(id);

        if (!location.isEmpty()) {
            Location pointForDelete=location.get();
            locationRepository.delete(pointForDelete);
            response = "deleted location";
        } else {
            response = "this location doesn't exist";
        }
        return response;
    }





}
