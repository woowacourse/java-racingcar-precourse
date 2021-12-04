package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class OutputView {
	private static final String RESULT_MESSAGE = "\n실행 결과";
	private static final String COLON = " : ";
	private static final String DASH = "-";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";
	private static final String COMMA = ", ";

	public void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public void printResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(createResultString(car));
		}
		System.out.println();
	}

	private String createResultString(Car car) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(car.getCarName());
		stringBuilder.append(COLON);
		for (int i = 0; i < car.getPosition(); i++) {
			stringBuilder.append(DASH);
		}

		return stringBuilder.toString();
	}

	public void printWinners(String[] winners) {
		System.out.println(createWinnersString(winners));
	}

	private String createWinnersString(String[] winners) {
		return WINNER_MESSAGE + String.join(COMMA, winners);
	}
}
