package com.init.GirlsInTeck.controller;

import com.init.GirlsInTeck.dto.PointDto;
import com.init.GirlsInTeck.entity.Point;
import com.init.GirlsInTeck.service.impl.ServicePoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerPoint {

    @Autowired
    private ServicePoint servicePoint;

    @GetMapping("/points")
    public ResponseEntity<?> getAllPoints(){
        ResponseEntity<?> points = null;
        try {
            points = ResponseEntity.status(HttpStatus.OK).body(servicePoint.listPoints());
        } catch (Exception ex) {
            points = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return points;
    }


    @PostMapping("/new_point")
    public ResponseEntity<?> createPoint(@RequestBody PointDto pointDto){
        ResponseEntity<?> result = null;
        try {

            Point newPoint = servicePoint.createPoint(pointDto);

            result = ResponseEntity.status(HttpStatus.CREATED).body(newPoint);

        } catch (Exception ex) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return result;
    }

    @GetMapping("/point/{id}")
    public ResponseEntity<?> getPointById(@PathVariable("id") int id){

        try {
            String response = servicePoint.getPointById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update_point/{id}")
    public ResponseEntity<?> updatePoint(@PathVariable int id, @RequestBody PointDto pointDto){
        try {
            String response = servicePoint.updatePoint(id, pointDto);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/point/{id}")
    public ResponseEntity<?> deletePointById(@PathVariable int id){

        try {
            String response = servicePoint.deletePointById(id);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
