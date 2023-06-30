package com.baseballmanager.bmapp.controller.player;

import com.baseballmanager.bmapp.model.Player;
import com.baseballmanager.bmapp.service.PlayerService;
import com.baseballmanager.bmapp.service.impl.PlayerServiceImpl;
import java.util.List;


public class PlayerController {
    private PlayerService playerService;

    public PlayerController() {
        playerService = new PlayerServiceImpl();
    }

    public void handleRequest(String request) {
        System.out.println("test");
        if (request.startsWith("선수등록?")) {
            String playerInfo = request.substring(6); // Extract player information from the request

            // Extract teamId, name, and position from player information
            Long teamId = null;
            String name = null;
            String position = null;

            String[] parameters = playerInfo.split("&");
            for (String parameter : parameters) {
                String[] keyValue = parameter.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];

                    switch (key) {
                        case "teamId":
                            teamId = Long.parseLong(value);
                            System.out.println(value);
                            break;
                        case "name":
                            name = value;
                            break;
                        case "position":
                            position = value;
                            break;
                    }
                }
            }

            if (teamId != null && name != null && position != null) {
                boolean result = playerService.registerPlayer(teamId, name, position);

                if (result) {
                    System.out.println("Success: 선수 등록 성공");
                } else {
                    System.out.println("Failure: 선수 등록 실패");
                }
            } else {
                System.out.println("Invalid request format for 선수등록");
            }
        } else {
            System.out.println("Invalid request");
        }
    }

    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
}