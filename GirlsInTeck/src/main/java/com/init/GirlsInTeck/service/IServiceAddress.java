package com.init.GirlsInTeck.service;

import com.init.GirlsInTeck.dto.AddressDto;
import com.init.GirlsInTeck.entity.Address;


public interface IServiceAddress {
    Address createAddress(AddressDto addressDto);
    String updateAddress(int id,AddressDto addressDt);
    String deleteAddressById(int id);
}
