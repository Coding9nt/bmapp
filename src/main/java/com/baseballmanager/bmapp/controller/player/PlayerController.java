package com.baseballmanager.bmapp.controller.player;

import com.baseballmanager.bmapp.model.Player;
import com.baseballmanager.bmapp.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/example")
    public void example() {
        playerService.example();
    }
}
