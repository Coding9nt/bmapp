package com.baseballmanager.bmapp.view;

import com.baseballmanager.bmapp.model.Player;

import java.util.List;

public class PlayerView {
    public void displayAllPlayers(List<Player> players) {
        System.out.println("선수 목록:");
        for (Player player : players) {
            System.out.println("ID: " + player.getId());
            System.out.println("팀 ID: " + player.getTeamId());
            System.out.println("이름: " + player.getName());
            System.out.println("포지션: " + player.getPosition());
            System.out.println("등록일시: " + player.getCreatedAt());
            System.out.println();
        }
    }
}
