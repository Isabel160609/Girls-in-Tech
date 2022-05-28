package com.init.GirlsInTeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.GirlsInTeck.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
