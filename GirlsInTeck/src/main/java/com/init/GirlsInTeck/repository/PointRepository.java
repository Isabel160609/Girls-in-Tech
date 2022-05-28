package com.init.GirlsInTeck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.GirlsInTeck.entity.Point;

@Repository
	public interface PointRepository extends JpaRepository <Point,Integer> {

	}

