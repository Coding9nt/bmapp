package com.baseballmanager.bmapp.dao;

import com.baseballmanager.bmapp.db.DBConnection;
import com.baseballmanager.bmapp.dto.OutPlayerRespDto;
import com.baseballmanager.bmapp.model.OutPlayer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OutPlayerDao {
    public boolean insertOutPlayer(OutPlayer outPlayer) {
        String query = "INSERT INTO out_player (reason, created_at, player_id) VALUES (?, NOW(), ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, outPlayer.getReason());
            preparedStatement.setInt(2, outPlayer.getPlayerId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<OutPlayerRespDto> getOutPlayers() {
        String query = "SELECT p.id, p.p_name, p.position, o.reason, o.day " +
                       "FROM player p LEFT JOIN out_player o ON p.id = o.player_id";

        List<OutPlayerRespDto> outPlayers = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                OutPlayerRespDto outPlayer = OutPlayerRespDto.fromResultSet(resultSet);
                outPlayers.add(outPlayer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outPlayers;
    }
}
