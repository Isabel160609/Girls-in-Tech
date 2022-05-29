package com.init.GirlsInTeck.controller;

import com.init.GirlsInTeck.dto.LocationDto;
import com.init.GirlsInTeck.dto.PointDto;
import com.init.GirlsInTeck.entity.Location;
import com.init.GirlsInTeck.entity.Point;
import com.init.GirlsInTeck.service.impl.ServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerLocation {

    @Autowired
    private ServiceLocation serviceLocation;


    @PostMapping("/new_location")
    public ResponseEntity<?> createLocation(@RequestBody LocationDto locationDto){
        ResponseEntity<?> result = null;
        try {

            Location newLocation = serviceLocation.createLocation(locationDto);

            result = ResponseEntity.status(HttpStatus.CREATED).body(newLocation);

        } catch (Exception ex) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return result;
    }

    @PutMapping("/update_location/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable int id, @RequestBody LocationDto locationDto){
        try {
            String response = serviceLocation.updateLocation(id, locationDto);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/location/{id}")
    public ResponseEntity<String> deleteLocationById(@PathVariable int id){

        try {
            String response = serviceLocation.deleteLocationById(id);

            return new ResponseEntity<String>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
