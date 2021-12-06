package view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.Car;

public class OutputView {
	private static final String FORWARD_MARK = "-";
	private static final int ZERO = 0;

	public static void printCarsPositionStatus(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + carPositionToString(car));
		}
		System.out.println();
	}

	private static String carPositionToString(Car car) {
		int position = car.getPosition();
		StringBuilder positionStringBuilder = new StringBuilder();
		while (position > ZERO) {
			positionStringBuilder.append(FORWARD_MARK);
			position--;
		}
		return positionStringBuilder.toString();
	}

	public static void printGameWinner(List<Car> carList) {
		Set<String> winnerNameSet = searchGameWinners(carList);
		System.out.println("최종 우승자 : ");
		System.out.println(winnerNameSet.toString()
			.replace("[", "")
			.replace("]", ""));
	}

	private static Set<String> searchGameWinners(List<Car> carList) {
		Set<String> winnerNameSet = new HashSet<>();
		int winnerPosition = 0;
		for (Car car : carList) {
			if (car.getPosition() > winnerPosition) {
				winnerPosition = car.getPosition();
				winnerNameSet.clear();
				winnerNameSet.add(car.getName());
			}
			if (car.getPosition() == winnerPosition) {
				winnerNameSet.add(car.getName());
			}
		}
		return winnerNameSet;
	}
}
