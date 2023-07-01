package com.baseballmanager.bmapp.controller.player;

import com.baseballmanager.bmapp.dto.OutPlayerRespDto;
import com.baseballmanager.bmapp.model.OutPlayer;
import com.baseballmanager.bmapp.model.Player;
import com.baseballmanager.bmapp.service.OutPlayerService;
import com.baseballmanager.bmapp.service.PlayerService;
import com.baseballmanager.bmapp.service.impl.PlayerServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    private final OutPlayerService outPlayerService;

    public void handleRequest(String request) {
        if (request.startsWith("선수등록?")) {
            String playerInfo = request.substring(5); // Extract player information from the request

            // Extract teamId, name, and position from player information
            int teamId = 0;
            String name = null;
            String position = null;

            String[] parameters = playerInfo.split("&");
            System.out.println("parameters : " + parameters.length);
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
                boolean result = playerService.registerPlayer(name, position, teamId);

                if (result) {
                    System.out.println("Success: 선수 등록 성공");
                } else {
                    System.out.println("Failure: 선수 등록 실패");
                }
            } else {
                System.out.println("Invalid request format for 선수등록");
            }
        } else if (request.startsWith("퇴출등록?")) {
            String[] params = request.split("&");
            int playerId = 0;
            String reason = null;
            for (String param : params) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];
                    if (key.equals("playerId")) {
                        playerId = Integer.parseInt(value);
                    } else if (key.equals("reason")) {
                        reason = value;
                    }
                }
            }
            if (playerId != 0 && reason != null) {
                boolean success = outPlayerService.registerOutPlayer(playerId, reason);
                if (success) {
                    System.out.println("퇴출 등록 성공");
                } else {
                    System.out.println("퇴출 등록 실패");
                }
            } else {
                System.out.println("잘못된 요청 형식");
            }

        } else {
            System.out.println("Invalid request");
        }
    }

    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    public List<OutPlayer> getAlloutPlayers() {
        return outPlayerService.getAllOutPlayers();
    }
}