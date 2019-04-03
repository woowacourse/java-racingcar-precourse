package edu.woowa.course.racing;

import java.util.Arrays;
import java.util.Collections;
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
	private static final String FINISH = "가 최종 우승했습니다.";
	private static final String LF = "\n\n";
	private static final int NAME_LIMIT = 5;
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

		System.out.print(LF);
		System.out.println(RESULT);
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
			carNames[i] = carNames[i].trim();
			if (carNames[i].length() > NAME_LIMIT || carNames[i].length() < 1) {
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
			count--;
		}
		System.out.println(getWinner());
	}

	private void notifyCars() {
		for (Car car: cars) {
			car.move();
			System.out.println(car);
		}
		System.out.print(LF);
	}

	private String getWinner() {
		Arrays.sort(cars);
		int maxPosition = cars[0].getPosition();
		StringBuilder sb = new StringBuilder();

		int i = 0;
		int len = cars.length;
		while ((i < len) && (cars[i].getPosition() == maxPosition)) {
			sb.append(cars[i].getName());
			sb.append(", ");
			i++;
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		return sb.append(FINISH).toString();
	}

	public static void main(String[] args) {
		new RacingGame();
	}
}
