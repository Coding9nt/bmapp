package com.baseballmanager.bmapp.model;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private int id;
    private String name;
    private String position;
    private LocalDateTime createdAt;
    private int teamId;

    public Player(String name, String position, LocalDateTime createdAt, int teamId) {
        this.name = name;
        this.position = position;
        this.createdAt = createdAt;
        this.teamId = teamId;
    }
}