package com.yida.demo.service;

import com.yida.demo.dao.HouseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
    // 构造器注入
    final HouseDAO houseDAO;

    @Autowired
    public HouseService(HouseDAO houseDAO) {
        this.houseDAO = houseDAO;
    }
}
