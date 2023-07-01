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
            String query = "INSERT INTO player (p_name , position, created_at,team_id ) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getPosition());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(player.getCreatedAt()));
            preparedStatement.setInt(4, player.getTeamId());
            result = preparedStatement.executeUpdate();
            System.out.println("DB Insert 완료!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String query = "select * from player";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("p_name");
                String position = resultSet.getString("position");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                int teamId = resultSet.getInt("team_id");
                Player player = new Player(id,name, position, createdAt, teamId);
                players.add(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }

    public boolean updatePlayerTeamId(int playerId, Integer teamId) {
        String query = "UPDATE player SET team_id = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, teamId);
            preparedStatement.setInt(2, playerId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}