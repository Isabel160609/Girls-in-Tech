package com.init.GirlsInTeck.service;

import com.init.GirlsInTeck.dto.PointDto;
import com.init.GirlsInTeck.entity.Point;

import java.util.List;

public interface IServicePoint {

    List<Point> listPoints();
    Point createPoint(PointDto pointDto);
    String deletePointById(int id);
    String getPointById(int id);
    String updatePoint(int id, PointDto PointDto);
}
