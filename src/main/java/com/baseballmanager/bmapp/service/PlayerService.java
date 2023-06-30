package com.baseballmanager.bmapp.service;

import com.baseballmanager.bmapp.model.Player;

import java.util.List;

public interface PlayerService {
    boolean registerPlayer(Long teamId, String name, String position);
    List<Player> getAllPlayers();
}