package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.view.OutputView;

public class OutputService {
	private static final String DISTANCE = "-";
	private static final String WINNER_NAME_DELIMITER = ", ";

	public static void getOneRoundRacingResult(List<Car> cars) {
		for (Car car : cars) {
			StringBuilder movedDistance = getCarMovedDistance(car.getPosition());
			OutputView.printCarNameAndPosition(car.getName(), movedDistance);
		}
		OutputView.printNewLine();
	}

	public static void getWinnerNameList(List<String> winner) {

		OutputView.printWinner(String.join(WINNER_NAME_DELIMITER, winner));
	}

	private static StringBuilder getCarMovedDistance(int position) {
		StringBuilder movedDistance = new StringBuilder();
		for (int i = 0; i < position; i++) {
			movedDistance.append(DISTANCE);
		}
		return movedDistance;
	}
}
