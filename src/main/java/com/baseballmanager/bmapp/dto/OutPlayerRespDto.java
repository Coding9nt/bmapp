package com.baseballmanager.bmapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class OutPlayerRespDto {
    private int id;
    private String name;
    private String position;
    private String reason;
    private LocalDate day;


    public static OutPlayerRespDto fromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String playerName = resultSet.getString("p_name");
        String position = resultSet.getString("position");
        String reason = resultSet.getString("reason");
        Timestamp timestamp = resultSet.getTimestamp("day");
        LocalDate day = timestamp != null ? timestamp.toLocalDateTime().toLocalDate() : null;

        return new OutPlayerRespDto(id, playerName, position, reason, day);
    }
}

