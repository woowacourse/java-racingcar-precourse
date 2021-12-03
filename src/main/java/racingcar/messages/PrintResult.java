package racingcar.messages;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.Car;

public class PrintResult {
	private static final String RESULT_DELIMITER = "-";
	private static final String	WINNER_DELIMITER = ", ";

	public void printGameResult(Car car) {
		int moveCount = car.getPosition();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < moveCount; i++) {
			stringBuilder.append(RESULT_DELIMITER);
		}
		System.out.println(car.getName() + " : " + stringBuilder);
	}

	public void printWinner(List<Car> gameWinners) {
		List<String> winnerList = gameWinners.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
		System.out.println("최종 우승자 : " + String.join(WINNER_DELIMITER, winnerList));
	}
}
