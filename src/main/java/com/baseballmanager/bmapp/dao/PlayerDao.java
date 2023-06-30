package com.baseballmanager.bmapp.dao;

import com.baseballmanager.bmapp.db.DBConnection;
import com.baseballmanager.bmapp.model.Player;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
    public int insert(Player player) {
        int result = 0;
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO players (team_id, name, position, created_at) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, player.getTeamId());
            preparedStatement.setString(2, player.getName());
            preparedStatement.setString(3, player.getPosition());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(player.getCreatedAt()));
            System.out.println("DB Insert 완료!");
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM players";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long teamId = resultSet.getLong("team_id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                Player player = new Player(id, teamId, name, position, createdAt);
                players.add(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }
}