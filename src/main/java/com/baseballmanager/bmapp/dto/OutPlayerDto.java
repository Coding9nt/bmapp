package com.baseballmanager.bmapp.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class OutPlayerDto {
    private Integer playerId;
    private String name;
    private String reason;
    private String position;
    private Timestamp createdAt;
}
