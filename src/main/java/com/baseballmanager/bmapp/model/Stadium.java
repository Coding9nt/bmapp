package com.baseballmanager.bmapp.model.stadium;

import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class Stadium {
    private Integer id;
    private String name;
    private Timestamp createdAt;
}
