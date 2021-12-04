package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import racingcar.model.Car;
import racingcar.util.Constants;

public class OutputView {
	private static final ArrayList<String> WINNER = new ArrayList<>();

	public static void askCarNames() {
		System.out.println(Constants.ASK_CAR_NAMES);
	}

	public static void askAttemptsNum() {
		System.out.println(Constants.ASK_ATTEMPTS_NUMBER);
	}

	public static void showAllProcess(Car[] cars, int attemptsNum) {
		for (int i = 0; i < attemptsNum; i++) {
			showProcess(cars);
			System.out.println();
		}
	}

	private static void showProcess(Car[] cars) {
		for (Car car : cars) {
			car.advance();
			int position = car.getPosition();
			System.out.println(car.getName() + " : " + String.join("", Collections.nCopies(position, "-")));
		}
	}

	public static void showWinner(Car[] cars) {
		getWinner(cars);
		System.out.print("최종 우승자 : ");
		for (int i = 0; i < WINNER.size(); i++) {
			System.out.print(WINNER.get(i));
			if (i != WINNER.size() - 1) {
				System.out.print(", ");
			}
		}
	}

	private static void getWinner(Car[] cars) {
		for (Car car : cars) {
			if (car.getPosition() == getMaxPosition(cars)) {
				WINNER.add(car.getName());
			}
		}
	}

	private static int getMaxPosition(Car[] cars) {
		int[] positions = new int[cars.length];
		for (int i = 0; i < cars.length; i++) {
			positions[i] = cars[i].getPosition();
		}
		int asInt = Arrays.stream(positions).max().getAsInt();
		return asInt;
	}

}
