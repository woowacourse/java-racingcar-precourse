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
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���. (�̸��� ��ǥ(,) �������� ����)");
		String carNames = scanner.nextLine();
		return carNames;
	}
}
