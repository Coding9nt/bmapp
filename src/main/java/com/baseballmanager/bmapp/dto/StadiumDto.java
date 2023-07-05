package com.baseballmanager.bmapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Builder
@ToString
public class StadiumDto {
    private Integer id;
    private String name;
    private Timestamp createdAt;
}
