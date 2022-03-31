package com.yida.demo.dao;

import com.yida.demo.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseDAO extends JpaRepository<House, Integer> {
}

