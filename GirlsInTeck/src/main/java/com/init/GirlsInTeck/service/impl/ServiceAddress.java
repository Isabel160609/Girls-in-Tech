package com.init.GirlsInTeck.service.impl;

import com.init.GirlsInTeck.dto.AddressDto;
import com.init.GirlsInTeck.entity.Address;
import com.init.GirlsInTeck.repository.AddressRepository;
import com.init.GirlsInTeck.service.IServiceAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceAddress implements IServiceAddress {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address createAddress(AddressDto addressDto) {

        Address newAddress=new Address();
        newAddress.setCity(addressDto.getCity());
        newAddress.setCp((addressDto.getCp()));
        newAddress.setNumber(addressDto.getNumber());
        newAddress.setStreet((addressDto.getStreet()));
        addressRepository.save(newAddress);
        return newAddress;
    }

    @Override
    public String updateAddress(int id, AddressDto addressDto) {
        String response;

        Optional<Address> Optional_address = addressRepository.findById(id);
        if (!Optional_address.isEmpty()) {
            Address updateAddress = Optional_address.get();
            updateAddress.setCity(addressDto.getCity());
            updateAddress.setCp((addressDto.getCp()));
            updateAddress.setNumber(addressDto.getNumber());
            updateAddress.setStreet((addressDto.getStreet()));
            addressRepository.save(updateAddress);
            response = "this address has been modified";
        } else {
            response = "this address doesn't exist";
        }
        return response;
    }

    @Override
    public String deleteAddressById(int id) {
        String response;
        Optional<Address> address = addressRepository.findById(id);

        if (!address.isEmpty()) {
            Address AddressForDelete=address.get();
            addressRepository.delete(AddressForDelete);
            response = "deleted address";
        } else {
            response = "this address doesn't exist";
        }
        return response;
    }

	
}

