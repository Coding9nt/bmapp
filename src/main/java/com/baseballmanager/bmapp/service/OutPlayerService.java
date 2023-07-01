package com.baseballmanager.bmapp.service;

import com.baseballmanager.bmapp.dto.OutPlayerRespDto;

import java.util.List;

public interface OutPlayerService {
    public List<OutPlayerRespDto> getAllOutPlayers();

    public boolean registerOutPlayer(int playerId, String reason);
}
