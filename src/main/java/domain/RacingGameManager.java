package domain;
/* 
 * Ŭ���� �̸� : RacingGameManager
 * �ۼ��� : Moonyoung Chae
 * ��¥ : 2019/04/02
 * Copyright (c) 2019 Moonyoung Chae
 */

import java.util.Scanner;

public class RacingGameManager {
	int totalCarCount; // ���ӿ� �����ϴ� �ڵ����� ��
	Car[] cars; // ���ӿ� �����ϴ� �ڵ��� ��ü
	Scanner scanner = new Scanner(System.in);

	public String getCarNamesFromUser() {
		String carNames;
		do {
			System.out.println("������ �ڵ��� �̸��� �Է��ϼ���. (�̸��� ��ǥ(,) �������� ����)");
			carNames = scanner.nextLine();
		} while (!checkCarNames(carNames));
		return carNames;
	}

	// �ڵ��� �̸��� �Է��ߴ��� Ȯ���մϴ�.
	public boolean checkCarNames(String carNames) {
		if (carNames.length() == 0) {
			System.out.println("�ڵ��� �̸��� �Էµ��� �ʾҽ��ϴ�.");
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
			System.out.println("�õ��� ȸ���� �� ȸ�ΰ���?");
			gameCountFromUser = scanner.nextInt();
		} while (!checkGameCount(gameCountFromUser));
		return gameCountFromUser;
	}

	// ���� Ƚ���� 1ȸ �̻����� Ȯ���մϴ�.
	public boolean checkGameCount(int gameCountFromUser) {
		if (gameCountFromUser > 0) {
			return true;
		}
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
		System.out.println(getWinnerNames() + "�� ���� ����߽��ϴ�.");
	}
}
