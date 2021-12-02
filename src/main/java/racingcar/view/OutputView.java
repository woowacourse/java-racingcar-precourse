package racingcar.view;

import java.util.ArrayList;

import racingcar.model.Car;

public class OutputView {

	public static void printRoundResult(ArrayList<Car> roundResult) {
		for (Car car : roundResult) {
			System.out.printf("%s : %s%n", car.getName(), dashRepeat(car.getPosition()));
		}
		System.out.println();
	}

	public static void printWinner(String[] winners) {
		String joinWinners = String.join(", ", winners);
		System.out.printf("최종 우승자 : %s%n", joinWinners);
	}

	public static String dashRepeat(int num) {
		StringBuilder dashes = new StringBuilder();
		for (int i = 0; i < num; i++) {
			dashes.append("-");
		}
		return dashes.toString();
	}
}
