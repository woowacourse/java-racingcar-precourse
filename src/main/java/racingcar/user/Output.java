package racingcar.user;

import java.util.ArrayList;

import racingcar.Car;

public class Output {
	private static final String COLON = " : ";
	private static final String DISTANCE = "-";
	private static final String SEPARATOR = ", ";
	private static final String ROUND_RESULT_MESSAGE = "실행 결과";
	private static final String CHAMPION_MESSAGE = "최종 우승자 : ";
	private static final int SINGLE_CHAMPION = 0;
	private static final int CAR_NAME = 0;
	private static final int CAR_POSITION = 1;

	public void printRoundResult(String round, Car[] cars) {
		System.out.println();
		System.out.println(ROUND_RESULT_MESSAGE);
		for (int i = 0; i < Integer.parseInt(round); i++) {
			move(cars);
			System.out.println();
		}
	}

	private void move(Car[] cars) {
		for (Car car : cars) {
			ArrayList<String> result = car.move();
			printResult(result.get(CAR_NAME), result.get(CAR_POSITION));
		}
	}

	private void printResult(String name, String position) {
		System.out.print(name + COLON);
		printDistance(Integer.parseInt(position));
		System.out.println();
	}

	private void printDistance(int result) {
		for (int i = 0; i < result; i++) {
			System.out.print(DISTANCE);
		}
	}

	public void printChampionList(ArrayList<String> champion) {
		System.out.print(CHAMPION_MESSAGE + champion.get(SINGLE_CHAMPION));
		printMultipleChampion(champion);
	}

	private void printMultipleChampion(ArrayList<String> champion) {
		for (int i = 1; i < champion.size(); i++) {
			System.out.print(SEPARATOR + champion.get(i));
		}
	}
}
