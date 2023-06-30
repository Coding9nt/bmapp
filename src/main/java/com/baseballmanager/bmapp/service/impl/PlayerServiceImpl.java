package com.baseballmanager.bmapp.service.impl;

import com.baseballmanager.bmapp.dao.PlayerDao;
import com.baseballmanager.bmapp.model.Player;
import com.baseballmanager.bmapp.service.PlayerService;

import java.time.LocalDateTime;
import java.util.List;


public class PlayerServiceImpl implements PlayerService {
    private PlayerDao playerDao;

    public PlayerServiceImpl() {
        playerDao = new PlayerDao();
    }

    @Override
    public boolean registerPlayer(Long teamId, String name, String position) {
        LocalDateTime createdAt = LocalDateTime.now();
        Player player = new Player(null, teamId, name, position, createdAt);
        int result = playerDao.insert(player);
        return result == 1;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerDao.getAllPlayers();
    }
}