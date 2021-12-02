package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	public static void printCarsStatus(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + getStringOfCarPosition(car.getPosition()));
		}
	}

	private static String getStringOfCarPosition(int carPosition) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < carPosition; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}
}
