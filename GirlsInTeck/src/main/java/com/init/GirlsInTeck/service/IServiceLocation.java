package com.init.GirlsInTeck.service;


import com.init.GirlsInTeck.dto.LocationDto;
import com.init.GirlsInTeck.entity.Location;

import java.util.List;

public interface IServiceLocation {

    Location createLocation(LocationDto locationDto);
    String updateLocation(int id, LocationDto locationDto);
    String deleteLocationById(int id);

}
