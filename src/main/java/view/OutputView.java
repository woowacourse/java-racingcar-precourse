package view;

import java.util.List;

import racingcar.Car;

public class OutputView {
	private static final String FORWARD_MARK = "-";
	private static final int ZERO = 0;

	public void printCarsPositionStatus(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + carPositionToString(car));
		}
		System.out.println();
	}

	private String carPositionToString(Car car) {
		int position = car.getPosition();
		StringBuilder positionStringBuilder = new StringBuilder();
		while (position >= ZERO) {
			positionStringBuilder.append(FORWARD_MARK);
			position--;
		}
		return positionStringBuilder.toString();
	}
}
