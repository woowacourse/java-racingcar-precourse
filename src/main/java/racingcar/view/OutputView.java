package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.util.Constant;

public class OutputView {
	public static void printMoveResult(Car car) {
		System.out.printf("%s : %s%n", car.toString(), car.getPositionAsString());
	}

	public static void printWinners(List<Car> winners) {
		System.out.print(Constant.OUTPUT_WINNER_MESSAGE);
		System.out.println(
			winners.stream()
				.map(Car::toString)
				.collect(Collectors.joining(", ")));
	}
}