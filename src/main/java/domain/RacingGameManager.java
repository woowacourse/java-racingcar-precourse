package domain;
/* 
 * 클래스 이름 : RacingGameManager
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/04/02
 * Copyright (c) 2019 Moonyoung Chae
 */

import java.util.Scanner;

public class RacingGameManager {
	int totalCarCount; // 게임에 참여하는 자동차의 수
	int totalGameCount = 0; // 게임 횟수
	Car[] cars; // 게임에 참여하는 자동차 객체
	Scanner scanner = new Scanner(System.in);

	public void run() {
		String carNamesFromUser = getCarNamesFromUser();
		makeCars(carNamesFromUser);
		totalGameCount = getGameCountFromUser();
		
		System.out.println("실행 결과");
		while (totalGameCount-- > 0) {
			raceCars();
			printNowSituation();
		}

		printWinnerNames();
	}

	public String getCarNamesFromUser() {
		String carNames;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
			carNames = scanner.nextLine();
		} while (!checkCarNames(carNames));
		return carNames;
	}

	// 자동차 이름을 입력했는지 확인합니다.
	public boolean checkCarNames(String carNames) {
		if (carNames.length() == 0) {
			System.out.println("자동차 이름이 입력되지 않았습니다.");
			return false;
		}
		return true;
	}

	public void makeCars(String carNames) {
		String[] splitedCarNames = carNames.split(",");
		totalCarCount = splitedCarNames.length;
		cars = new Car[totalCarCount];

		for (int i = 0; i < totalCarCount; i++) {
			cars[i] = new Car(splitedCarNames[i]);
		}
	}

	public int getGameCountFromUser() {
		int gameCountFromUser;
		do {
			System.out.println("시도할 회수는 몇 회인가요?");
			gameCountFromUser = scanner.nextInt();
		} while (!checkGameCount(gameCountFromUser));
		return gameCountFromUser;
	}

	// 게임 횟수가 1회 이상인지 확인합니다.
	public boolean checkGameCount(int gameCountFromUser) {
		if (gameCountFromUser > 0) {
			return true;
		}
		System.out.println("시도 회수는 1회 이상이여야 합니다.");
		return false;
	}

	public void raceCars() {
		for (int i = 0; i < totalCarCount; i++) {
			cars[i].race();
		}
	}

	public void printNowSituation() {
		System.out.println();
		for (int i = 0; i < totalCarCount; i++) {
			cars[i].printNameAndPosition();
		}
		System.out.println();
	}

	public String getWinnerNames() {
		int maxPosition = -1;
		String winnerNames = "";
		for (int i = 0; i < totalCarCount; i++) {
			if (cars[i].getPostion() == maxPosition) {
				winnerNames += cars[i].getName() + ", ";
			}
			if (cars[i].getPostion() > maxPosition) {
				winnerNames = cars[i].getName() + ", ";
				maxPosition = cars[i].getPostion();
			}
		}
		winnerNames = winnerNames.substring(0, winnerNames.length() - 2);
		return winnerNames;
	}

	public void printWinnerNames() {
		System.out.println();
		System.out.println();
		System.out.println(getWinnerNames() + "가 최종 우승했습니다.");
	}
}
