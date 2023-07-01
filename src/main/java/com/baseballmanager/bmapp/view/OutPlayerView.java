package com.baseballmanager.bmapp.view;

import com.baseballmanager.bmapp.model.OutPlayer;
import com.baseballmanager.bmapp.model.Player;

import java.util.List;

public class OutPlayerView {
    public void displayAllOutPlayers(List<OutPlayer> outPlayers) {
        if (outPlayers.isEmpty()) {
            System.out.println("퇴출된 선수가 없습니다.");
        } else {
            System.out.println("[퇴출된 선수 목록]");
            System.out.println("ID\t이름\t포지션\t사유\t날짜");

            for (OutPlayer outPlayer : outPlayers) {
                System.out.println(outPlayer.getId() + "\t" +
                                   outPlayer.getName() + "\t" +
                                   outPlayer.getPosition() + "\t" +
                                   outPlayer.getReason() + "\t" +
                                   outPlayer.getDay());
            }
        }
    }
}
