package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.view.OutputView;

public class OutputService {
	private static final String DISTANCE = "-";
	private static final String DELIMITER = ", ";

	public static void getOneRoundRacingResult(List<Car> cars) {
		for (Car car : cars) {
			StringBuilder distance = getCarMovedDistance(car.getPosition());
			OutputView.printCarNameAndPosition(car.getName(), distance);
		}
		OutputView.printNewLine();
	}

	public static void getWinnerNameList(List<String> winner) {

		OutputView.printWinner(String.join(DELIMITER, winner));
	}

	private static StringBuilder getCarMovedDistance(int position) {
		StringBuilder movedDistance = new StringBuilder();
		for (int i = 0; i < position; i++) {
			movedDistance.append(DISTANCE);
		}
		return movedDistance;
	}
}
