package com.baseballmanager.bmapp.model;

import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@ToString
public class Stadium {
    private Integer id;
    private String name;
    private Timestamp createAt;
    @Builder
    public Stadium(int id, String name, Timestamp createAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
    }
}
