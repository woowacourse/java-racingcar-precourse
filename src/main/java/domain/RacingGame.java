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
		private static final String POSITION_OF_CAR = "-";
		private static final String BLANK = "";
		private static final String WINNTER_DELIMITER = ", ";
		private static final String PREDICATE_OF_WINNER_MESSAGE = "(이)가 최종 우승했습니다.";
		
		private static final int INITIAL_VALUE = 0;
		
		/** 우승자를 출력할 때 앞 부분(, )을 지우기 위한 상수 */
		private static final int SUBSTRING_COMMA_AND_SPACING = 2;
		
		private String[] carNameList;
		private Car[] racingCars;
		private String winner;
		private int numOfTry;
		private int maxPosition;
	
		public void runGame() {
				getCarNames(); 
				getNumOfTry();
				prepareRacingCars();
				startRacing();
				finishRacing();
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
				for (int i = 0; i < numOfTry; i++) {
						for (int j = 0; j < racingCars.length; j++) {
								racingCars[j].updatePositionOfCar();
								printPositionOfCar(racingCars[j]);
						}
						System.out.println(BLANK);
				}
		}
	
		private void printPositionOfCar(Car racingCars) {
				System.out.print(racingCars.getName() + " : ");
				for (int i = 0; i < racingCars.getPosition(); i++) {
						System.out.print(POSITION_OF_CAR);
				}
				System.out.println(BLANK);
		}
	
		/**
		 * 경기를 마치는 메소드로 우승자를 선정하는 메소드와 출력하는 메소드로 이루어져
		 * 있습니다.
		 */
		private void finishRacing() {
				decideWinner();
				printWinner();
		}
	
		/**
		 * 우승자를 선정하는 메소드로 가장 많이 이동한 거리를 구하는 메소드와 가장 많은
		 * 거리를 이동한 자동차의 이름을 구하는 메소드로 구성되어 있습니다.
		 */
		private void decideWinner() {
				getMaxPosition();
				getCarsNameInMaxPosition();
		}
	
		private void getMaxPosition() {
				maxPosition = INITIAL_VALUE;
				for (Car racingCar : racingCars) {
						if (racingCar.getPosition() >= maxPosition) {
								maxPosition = racingCar.getPosition();
						}
				}
		}
		
		private void getCarsNameInMaxPosition() {
				winner = BLANK;
				for (Car racingCar : racingCars) {
						if (racingCar.getPosition() == maxPosition) {
								winner += WINNTER_DELIMITER + racingCar.getName();
						}
				}
		}

		private void printWinner() {
				System.out.print(winner.substring(SUBSTRING_COMMA_AND_SPACING) + PREDICATE_OF_WINNER_MESSAGE);
		}
}