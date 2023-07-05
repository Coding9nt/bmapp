package com.baseballmanager.bmapp.dao;

import com.baseballmanager.bmapp.dto.TeamDto;
import com.baseballmanager.bmapp.model.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {
    private Connection connection;

    public TeamDao(Connection connection) {
        this.connection = connection;
    }

    public int createTeam(int stadiumId, String name) throws SQLException {
        String query = "INSERT INTO team (stadium_id, name, created_at) VALUES(?,?,now())";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, stadiumId);
            statement.setString(2, name);

            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<TeamDto> getTeamList() {
        List<TeamDto> teams = new ArrayList<>();

        String query = "SELECT t.id, stadium.name, team.name" +
                "FROM team" +
                "JOIN stadium ON team.stadium_id = stadium.id";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    teams.add(getTeamResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    public TeamDto getTeamResultSet(ResultSet resultSet) {
        try {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Integer stadiumId = resultSet.getInt("stadium_id");
            String stadiumName = resultSet.getString("stadium_name");
            Timestamp createdAt = resultSet.getTimestamp("created_at");

            return TeamDto.builder()
                    .id(id)
                    .name(name)
                    .stadiumId(stadiumId)
                    .createdAt(createdAt)
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
