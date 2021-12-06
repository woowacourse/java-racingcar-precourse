package racingcar.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.Car;

public class ResultView {
	private static final String EQUALS_MESSAGE = " : ";
	private static final String WINNER_MESSAGE = "최종 우승자";
	private static final String DASH_MESSAGE = "-";

	//현재 포지션 출력
	public static void printPosition(List<Car> carList) {
		for (Car car : carList) {
			String name = car.getName();
			String currentPosition = String.join("", Collections.nCopies(car.getPosition(), DASH_MESSAGE));
			System.out.println(name + EQUALS_MESSAGE + currentPosition);
		}
	}

	//우승자 출력
	public static void printWinners(List<Car> carList) {
		List<String> winners = new ArrayList<>();
		int maxPosition = getMaxPosition(carList);

		for (Car car : carList) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		System.out.println(WINNER_MESSAGE + EQUALS_MESSAGE + String.join(", ", winners));
	}

	public static int getMaxPosition(List<Car> carList) {
		int maxPosition = 0;

		for (Car car : carList) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}


