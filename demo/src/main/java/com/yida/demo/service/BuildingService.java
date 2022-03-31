package com.yida.demo.service;

import com.yida.demo.dao.BuildingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    // 构造器注入
    final BuildingDAO buildingDAO;

    @Autowired
    public BuildingService(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }
}
