package com.baseballmanager.bmapp.service;

import com.baseballmanager.bmapp.dao.StadiumDao;
import com.baseballmanager.bmapp.model.Stadium;

import java.util.List;

public class StadiumService {
    private StadiumDao stadiumDao;

    public StadiumService(StadiumDao stadiumDao) {
        this.stadiumDao = stadiumDao;
    }

    // add stadium
    public String createStadium(String sName) {
        int result = stadiumDao.createStadium(sName);

        if (result > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    }

    // stadium list
    public List<Stadium> getStadium() {
        List<Stadium> stadiums = stadiumDao.getStadiumList();
        if (stadiums != null && !stadiums.isEmpty()) {
            return stadiums;
        } else {
            return List.of();
        }
    }
}
