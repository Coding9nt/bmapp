package com.baseballmanager.bmapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Builder
@ToString
public class TeamDto {
    private Integer id;
    private Integer stadiumId;
    private String name;
    private Timestamp createdAt;
}
