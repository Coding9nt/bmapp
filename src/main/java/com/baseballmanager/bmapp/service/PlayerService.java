package com.baseballmanager.bmapp.service;

import com.baseballmanager.bmapp.model.OutPlayer;
import com.baseballmanager.bmapp.model.Player;

import java.util.List;

public interface PlayerService {
    boolean registerPlayer(String name, String position,int teamId);
    List<Player> getAllPlayers();
}