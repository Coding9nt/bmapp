package com.baseballmanager.bmapp.dao;

import com.baseballmanager.bmapp.model.Stadium;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StadiumDao {
    private Connection connection;

    public StadiumDao(Connection connection) {
        this.connection = connection;
    }
    // create data
    public int createStadium(String name) {
        String query = "INSERT INTO stadium (name, created_at) VALUES(?, now())";

        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // get stadium
    public List<Stadium> getStadiumList() {
        List<Stadium> stadiums = new ArrayList<>();
        String query = "SELECT * FROM stadium";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Stadium stadium = getStadiumResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Stadium getStadiumResultSet(ResultSet resultSet) {
        try {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Timestamp createdAt = resultSet.getTimestamp("created_at");

            return Stadium.builder()
                    .id(id)
                    .name(name)
                    .createdAt(createdAt)
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
