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
		private static final String INPUT_TRY_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
		private static final String EXECUTION_RESULT = "\n실행 결과";
		private static final String BLANK = "";
		
		private String[] carNameList;
		private Car[] racingCars;
		private int numOfTry;
	
		public void runGame() {
				getCarNames(); 
				getNumOfTry();
				prepareRacingCars();
				startRacing();
		}

		private void getCarNames() {
				do {
						System.out.println(INPUT_CAR_NAME_MESSAGE);
						String carNames = SCANNER.nextLine();
						carNameList = carNames.split(DELIMITER_COMMA);
				} while (!Validation.isValidCarName(carNameList));
		}
	
		private void getNumOfTry() {
				String strOfTry = BLANK;
				do {
						System.out.println(INPUT_TRY_NUMBER_MESSAGE);
						strOfTry = SCANNER.nextLine();
				} while (!Validation.isValidTryNum(strOfTry));
				numOfTry = Integer.parseInt(strOfTry);
		}
		
		/**
		 * 각각의 경주용 차를 준비하기 위해 Car 객체를 이용해 구성합니다.
		 */
		private void prepareRacingCars() {
				racingCars = new Car[carNameList.length];
				for (int i = 0; i < carNameList.length; i++) {
						racingCars[i] = new Car(carNameList[i].trim());
				}
		}
		
		/**
		 * 레이싱을 시작하는 메소드로 '실행 결과'라는 제목을 출력하는 메소드와 각 라운드를
		 * 진행하는 메소드로 이루어져 있습니다.
		 */
		private void startRacing() {
				printTitle();
				progressRound();
		}
	
		private void printTitle() {
				System.out.println(EXECUTION_RESULT);
		}
	
		/**
		 * 각 라운드를 진행하는 메소드로 자동차의 위치를 갱신하고 출력하는 메소드를 내포하고
		 * 있습니다.
		 */
		private void progressRound() {

		}
}