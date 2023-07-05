package com.baseballmanager.bmapp.controller.player;

import com.baseballmanager.bmapp.model.Player;
import com.baseballmanager.bmapp.service.PlayerService;

import java.util.List;


public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(final PlayerService playerService) {
        this.playerService = playerService;
    }


    public void example() {
        playerService.example();
    }
}
