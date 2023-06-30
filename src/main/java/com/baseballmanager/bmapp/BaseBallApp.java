package com.baseballmanager.bmapp;


import com.baseballmanager.bmapp.controller.player.PlayerController;
import com.baseballmanager.bmapp.model.Player;
import com.baseballmanager.bmapp.view.PlayerView;

import java.util.List;
import java.util.Scanner;

public class BaseBallApp {
	private static PlayerController playerController;

	public static void main(String[] args) {
		playerController = new PlayerController();
		appStart();
	}

	public static void appStart() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("어떤 기능을 요청하시겠습니까?");
			System.out.println("선수등록 OR 선수목록 : ");
			System.out.println("END : 프로그램 종료");
			String input = sc.nextLine();
			if (input.equals("END") || input.equals("end")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (input.equals("선수등록")) {
				System.out.println("선수 등록을 위한 정보를 입력하세요.");
				System.out.print("팀 ID: ");
				Long teamId = Long.parseLong(sc.nextLine());
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("포지션: ");
				String position = sc.nextLine();

				String request = "teamId=" + teamId + "&name=" + name + "&position=" + position;
				playerController.handleRequest(request);
			} else if (input.startsWith("선수등록?")) {
				String request = input;
				playerController.handleRequest(request);
			} else if (input.equals("선수목록")) {
				List<Player> players = playerController.getAllPlayers();
				PlayerView playerView = new PlayerView();
				playerView.displayAllPlayers(players);
			}
		}
	}
}