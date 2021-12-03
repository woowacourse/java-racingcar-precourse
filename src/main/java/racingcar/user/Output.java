package racingcar.user;

import java.util.ArrayList;

import racingcar.Car;

public class Output {
	private static final String DISTANCE = "-";
	private static final String COLON = " : ";
	private static final String SEPARATOR = ", ";
	private static final String ROUND_RESULT_MESSAGE = "실행 결과";
	private static final String CHAMPION_MESSAGE = "최종 우승자 : ";
	private static final int SINGLE_CHAMPION = 0;

	public void printRoundResult(String round, Car[] cars) {
		System.out.println();
		System.out.println(ROUND_RESULT_MESSAGE);
		for (int i = 0; i < Integer.parseInt(round); i++) {
			moveCars(cars);
			System.out.println();
		}
	}

	private void moveCars(Car[] cars) {
		for (Car car : cars) {
			car.move();
			printResult(car);
		}
	}

	private void printResult(Car car) {
		System.out.print(car.getName() + COLON);
		printDistance(car.getPosition());
		System.out.println();
	}

	private void printDistance(int result) {
		for (int i = 0; i < result; i++) {
			System.out.print(DISTANCE);
		}
	}

	public void printChampionList(ArrayList<String> champion) {
		System.out.print(CHAMPION_MESSAGE + champion.get(SINGLE_CHAMPION));
		for (int i = 1; i < champion.size(); i++) {
			System.out.print(SEPARATOR + champion.get(i));
		}
	}
}
