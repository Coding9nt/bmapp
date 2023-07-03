package com.baseballmanager.bmapp.service;

import com.baseballmanager.bmapp.dao.TeamDao;
import com.baseballmanager.bmapp.dto.TeamDto;

import java.sql.SQLException;
import java.util.List;

public class TeamService {
    private TeamDao teamDao;

    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public String createTeam(int stadiumId, String name) throws SQLException {
        int result = teamDao.createTeam(stadiumId, name);

        if (result > 0) {
            return "Success";
        }
        else {
            return "Fail";
        }
    }

    public List<TeamDto> getTeamList() {
        List<TeamDto> teams = teamDao.getTeamList();

        if (!teams.isEmpty()) {
            return teams;
        } else {
            return List.of();
        }
    }
}
