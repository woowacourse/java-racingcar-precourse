package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
	public static void printMoveResult(Car car) {
		String result = String.format("%s : %s", car.getName(), car.getPositionAsString());
		System.out.println(result);
	}
}