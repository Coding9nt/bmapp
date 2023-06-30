package com.baseballmanager.bmapp.model;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private Long id;
    private Long teamId;
    private String name;
    private String position;
    private LocalDateTime createdAt;
}