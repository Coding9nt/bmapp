package com.baseballmanager.bmapp.model;


import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Player {
    private Integer id;

    private String name;

    private String position;

    private Timestamp createdAt;
    private Integer teamId;

    @Builder
    public Player(final String name,
                  final String position) {
        this.name = name;
        this.position = position;
    }

    public void enrollTeam(final Integer teamId) {
        this.teamId = teamId;
    }
    
    // 도메인 서비스에 들어 갈 로직(비즈니스 로직) 작성
    // 절대로 서비스 레이어에 비즈니스 로직이 들어가면 안됨. ( 서비스 레이어는 최대한 가볍게 구현. )
    // TDA(Tell Don't Ask) 원칙 준수
}
