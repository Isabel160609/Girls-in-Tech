package com.init.GirlsInTeck.controller;

import com.init.GirlsInTeck.dto.AddressDto;
import com.init.GirlsInTeck.dto.LocationDto;
import com.init.GirlsInTeck.entity.Address;
import com.init.GirlsInTeck.entity.Location;
import com.init.GirlsInTeck.service.impl.ServiceAddress;
import com.init.GirlsInTeck.service.impl.ServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerAddress {

    @Autowired
    private ServiceAddress serviceAddress;


    @PostMapping("/new_address")
    public ResponseEntity<?> createAddress(@RequestBody AddressDto addressDto){
        ResponseEntity<?> result = null;
        try {

            Address newAddress = serviceAddress.createAddress(addressDto);

            result = ResponseEntity.status(HttpStatus.CREATED).body(newAddress);

        } catch (Exception ex) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return result;
    }

    @PutMapping("/update_address/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable int id, @RequestBody AddressDto addressDto){
        try {
            String response = serviceAddress.updateAddress(id, addressDto);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable int id){

        try {
            String response = serviceAddress.deleteAddressById(id);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
