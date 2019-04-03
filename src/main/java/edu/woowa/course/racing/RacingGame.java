package edu.woowa.course.racing;

import java.util.Scanner;

import edu.woowa.course.racing.domain.Car;

/**
*@version 1.00 2019/04/03
*@author 조재훈
*/
public class RacingGame {

	private static final String REQ_CAR_NAME ="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String REQ_COUNT = "시도할 횟수는 몇회인가요?";
	private static final String RESULT = "실행 결과";
	private Scanner scanner;
	private Car[] cars;
	private int count;

	public RacingGame() {
		this.scanner = new Scanner(System.in);

		do {
			System.out.println(REQ_CAR_NAME);
		} while (!isValidCars());

		do {
			System.out.println(REQ_COUNT);
		} while (!isValidCount());

		play();
	}

	private boolean isValidCars() {
		if (scanner.hasNextLine()) {
			String[] carNames = scanner.nextLine().split(",", -1);
			return setCars(carNames);
		}
		return false;
	}

	private boolean setCars(String[] carNames) {
		int len = carNames.length;
		cars = new Car[len];

		for (int i = 0; i < len; i++) {
			if(carNames[i].length() > 5 || carNames[i].length() < 1) {
				return false;
			}
			cars[i] = new Car(carNames[i]);
		}
		return true;
	}

	private boolean isValidCount() {
		if (scanner.hasNextLine()) {
			try {
				count = Integer.valueOf(scanner.nextLine().trim());
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return (count < 0 ? false : true);
	}

	private void play() {
		while ( count > 0 ) {
			notifyCars();
			printCars();
			count--;
		}
		checkWinner();
	}

	private void notifyCars() {
		for(Car car: cars) {
			car.move();
		}
	}

	private void printCars() {
		
	}

	private void checkWinner() {
		
	}

	public static void main(String[] args) {
		new RacingGame();
	}
}
