package com.yida.demo.dao;

import com.yida.demo.entity.Village;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VillageDAO extends JpaRepository<Village, Integer> {
}

