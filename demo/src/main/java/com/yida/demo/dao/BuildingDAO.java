package com.yida.demo.dao;

import com.yida.demo.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingDAO extends JpaRepository<Building, Integer> {
}
