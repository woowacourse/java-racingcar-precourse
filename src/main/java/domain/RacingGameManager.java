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
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		String carNames = scanner.nextLine();
		return carNames;
	}
}
