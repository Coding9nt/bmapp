package com.baseballmanager.bmapp;


import com.baseballmanager.bmapp.view.BaseBallView;

import java.util.Scanner;

public class BaseBallApp {

	public static void main(String[] args) {
		appStart();
	}

	public static void appStart() {
		BaseBallView baseBallView = new BaseBallView();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n어떤 기능을 요청하시겠습니까?");
			System.out.println("야구장등록 OR 야구장목록 : ");
			System.out.println("팀등록 OR 팀목록 : ");
			System.out.println("선수등록 OR 선수목록 : ");
			System.out.println("END : 프로그램 종료");
			String input = sc.nextLine();
			if (input.equals("END") || input.equals("end")) {
				System.out.println("\n프로그램을 종료합니다.");
				break;
			}


		}
	}

}
