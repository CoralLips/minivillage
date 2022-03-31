package com.yida.demo.service;

import com.yida.demo.dao.VillageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VillageService {
    // 构造器注入
    final VillageDAO villageDAO;

    @Autowired
    public VillageService(VillageDAO villageDAO) {
        this.villageDAO = villageDAO;
    }


}
