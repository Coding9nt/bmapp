package com.baseballmanager.bmapp.service.impl;

import com.baseballmanager.bmapp.dao.OutPlayerDao;
import com.baseballmanager.bmapp.db.DBConnection;
import com.baseballmanager.bmapp.dto.OutPlayerRespDto;
import com.baseballmanager.bmapp.model.OutPlayer;
import com.baseballmanager.bmapp.service.OutPlayerService;
import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class OutPlayerServiceImpl implements OutPlayerService {

    private final OutPlayerDao outPlayerDao;
    @Override
    public boolean registerOutPlayer(int playerId, String reason) {
        try (Connection connection = DBConnection.getConnection()) {
            connection.setAutoCommit(false);

            // Insert outplayer record
            OutPlayer outPlayer = new OutPlayer();
            outPlayer.setReason(reason);
            outPlayer.setDay(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
            outPlayer.setPlayerId(playerId);
            boolean success = outPlayerDao.insertOutPlayer(outPlayer);

            // Update player record
            if (success) {
                String updateQuery = "UPDATE player SET team_id = NULL WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setInt(1, playerId);
                    preparedStatement.executeUpdate();
                }
            }

            connection.commit();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<OutPlayerRespDto> getAllOutPlayers() {
        List<OutPlayerRespDto> outPlayers = new ArrayList<>();

        String query = "SELECT o.id, p.name, p.position, o.reason, o.created_at " +
                        "FROM out_player o " +
                        "JOIN player p ON o.player_id = p.id";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                String reason = resultSet.getString("reason");
                Timestamp timestamp = resultSet.getTimestamp("created_at");
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM월 dd일");
                String day = dateFormat.format(timestamp);

                OutPlayerRespDto outPlayer = new OutPlayerRespDto(id, name, position, reason, day);
                outPlayers.add(outPlayer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outPlayers;
    }

}