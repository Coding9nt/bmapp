package com.baseballmanager.bmapp.controller.player;

import com.baseballmanager.bmapp.model.Player;
import com.baseballmanager.bmapp.service.PlayerService;
import com.baseballmanager.bmapp.service.impl.PlayerServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    public void handleRequest(String request) {
        if (request.startsWith("선수등록?")) {
            String playerInfo = request.substring(5); // Extract player information from the request

            // Extract teamId, name, and position from player information
            int teamId = 0;
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
                            teamId = Integer.parseInt(value);
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

            if (teamId != 0 && name != null && position != null) {
                boolean result = playerService.registerPlayer(name, position,teamId);

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