package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.util.Constant;

public class OutputView {
	public static void printMoveResult(Car car) {
		System.out.printf("%s : %s%n", car.getName(), car.getPositionAsString());
	}

	public static void printWinners(List<Car> winners) {
		System.out.print(Constant.OUTPUT_WINNER_MESSAGE);
		for (int i = 0; i < winners.size(); i++) {
			System.out.printf(" %s", winners.get(i).getName());
			if (i != winners.size() - 1) {
				System.out.print(",");
			}
		}
	}
}