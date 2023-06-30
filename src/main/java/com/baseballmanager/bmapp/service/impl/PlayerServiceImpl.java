package com.baseballmanager.bmapp.service.impl;

import com.baseballmanager.bmapp.dao.PlayerDao;
import com.baseballmanager.bmapp.model.Player;
import com.baseballmanager.bmapp.service.PlayerService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerDao playerDao;

    @Override
    public boolean registerPlayer(String name, String position,int teamId) {
        LocalDateTime createdAt = LocalDateTime.now();
        Player player = new Player(name, position, createdAt, teamId);
        int result = playerDao.insert(player);
        return result == 1;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerDao.getAllPlayers();
    }
}