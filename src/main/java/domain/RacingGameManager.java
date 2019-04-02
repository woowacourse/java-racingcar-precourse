package domain;
/* 
 * 클래스 이름 : RacingGameManager
 * 작성자 : Moonyoung Chae
 * 날짜 : 2019/04/02
 * Copyright (c) 2019 Moonyoung Chae
 */

import java.util.Scanner;

public class RacingGameManager {
	Scanner scanner = new Scanner(System.in);

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
}
