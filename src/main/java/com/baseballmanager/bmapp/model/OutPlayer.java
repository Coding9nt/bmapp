package com.baseballmanager.bmapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutPlayer {
    private int id;
    private String name;
    private String position;
    private String reason;
    private String day;
    private int playerId;

    public OutPlayer(int id, String name, String position, String reason, String day) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.reason = reason;
        this.day = day;
    }
}
