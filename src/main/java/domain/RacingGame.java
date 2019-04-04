/*
 * @(#)RacingGame.java		2019/4/4
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * RacingGame 클래스는 게임을 전체적인 흐름을 보여주고 진행하는 기능을 합니다.
 * 
 * @version			1.00 2019년 4월 4일
 * @author 			한준모
 */

package domain;

import java.util.Scanner;

public class RacingGame {
		private static Scanner SCANNER = new Scanner(System.in);
		
		private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요."
				+ "(이름은 쉼표(,) 기준으로 구분)";
		private static final String DELIMITER_COMMA = ",";
		
		private String[] carNameList;
	
		public void runGame() {
				getCarNames(); 
		}

		private void getCarNames() {
				do {
						System.out.println(INPUT_CAR_NAME_MESSAGE);
						String carNames = SCANNER.nextLine();
						carNameList = carNames.split(DELIMITER_COMMA);
				} while (!Validation.isValidCarName(carNameList));
		}
}