package domain;
/* 
 * Ŭ���� �̸� : RacingGameManager
 * �ۼ��� : Moonyoung Chae
 * ��¥ : 2019/04/02
 * Copyright (c) 2019 Moonyoung Chae
 */

import java.util.Scanner;

public class RacingGameManager {
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
}
