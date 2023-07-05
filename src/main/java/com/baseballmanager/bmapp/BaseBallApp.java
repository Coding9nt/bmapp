package com.baseballmanager.bmapp;


import com.baseballmanager.bmapp.view.BaseBallView;

import java.util.Scanner;

public class BaseBallApp {

	public static BaseBallApp baseBallApp;
	public static BaseBallApp getInstance() {
		if (baseBallApp == null) {
			baseBallApp = new BaseBallApp();
		}
		return baseBallApp;
	}
	public static void details() {
		System.out.println("\n어떤 기능을 요청하시겠습니까?");
		System.out.println("기능 (ex : 선수등록?teamId=1&name=이대호&position=1루수)");
		System.out.println("프로그램 종료(END)");
	}
	public static void start() {
		details();
		BaseBallView baseBallView = new BaseBallView();
		Scanner sc = new Scanner(System.in);

		while (true) {
			String input = sc.nextLine();
			if (input.equals("END") || input.equals("end")) {
				break;
			}

			String[] restAPI = input.split("\\?");
			String command = restAPI[0];


		}
		System.out.println("프로그램을 종료합니다.");
	}
}
