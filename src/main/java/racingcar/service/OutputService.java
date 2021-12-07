package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.type.DelimiterType;
import racingcar.view.OutputView;

public class OutputService {


	public static void getOneRoundRacingResult(List<Car> cars) {
		for (Car car : cars) {
			StringBuilder movedDistance = getCarMovedDistance(car.getPosition());
			OutputView.printCarStatus(car.getName(), movedDistance);
		}
		OutputView.printNewLine();
	}

	public static void getWinnerNameList(List<String> winner) {

		OutputView.printWinner(String.join(DelimiterType.DISTANCE.getDelimiter(), winner));
	}

	private static StringBuilder getCarMovedDistance(int position) {
		StringBuilder movedDistance = new StringBuilder();
		for (int i = 0; i < position; i++) {
			movedDistance.append(DelimiterType.DISTANCE.getDelimiter());
		}
		return movedDistance;
	}
}
