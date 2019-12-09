package domain;

import java.util.ArrayList;
import java.util.Collections;

public class Winner {

	private static final int ZERO = 0;
	private static final String COMMA = ",";
	private static final String WINNING_MESSAGE = "가 최종 우승했습니다.";

	static ArrayList<String> getFirstRunners(ArrayList<Car> carList) {
		ArrayList<String> firstRunners = new ArrayList(carList.size());

		int firstRunnersPosition = getFirstRunnersPosition(carList);

		for (Car car : carList) {
			if (car.getPosition() == firstRunnersPosition) {
				firstRunners.add(car.getName());
			}
		}
		return firstRunners;
	}

	static int getFirstRunnersPosition(ArrayList<Car> carList) {
		int firstRunnersPosition;
		ArrayList<Integer> positions = new ArrayList(carList.size());

		for (Car car : carList) {
			int position = car.getPosition();
			positions.add(position);
		}

		firstRunnersPosition = Collections.max(positions);
		return firstRunnersPosition;
	}

	static void printWinners(ArrayList<String> firstRunners) {
		StringBuilder sb = new StringBuilder();

		for (String firstRunner : firstRunners) {
			if (sb.length() > ZERO) {
				sb.append(COMMA);
			}
			sb.append(firstRunner);
		}

		sb.append(WINNING_MESSAGE);
		System.out.println(sb.toString());

	}
}
