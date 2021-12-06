package racingcar.utils;

import java.util.List;

import racingcar.constants.Constant;
import racingcar.constants.Message;
import racingcar.domain.Car;

public class Viewer {
	private Viewer() {
	}

	public static void showEachStageResult(List<Car> cars) {
		for (Car car : cars) {
			showCarCurrentPosition(car);
		}
		System.out.println(Constant.EMPTY);
	}

	private static void showCarCurrentPosition(Car car) {
		System.out.print(car.name() + Constant.COLON);
		for (int i = 0; i < car.currentPosition(); i++) {
			System.out.print(Constant.PROGRESS);
		}
		System.out.println(Constant.EMPTY);
	}

	public static void showWinnerCars(List<Car> winnerCars) {
		System.out.print(Message.WINNERS);
		System.out.println(formatting(winnerCars));
	}

	private static StringBuilder formatting(List<Car> winnerCars) {
		StringBuilder winners = new StringBuilder();

		for (int i = 0; i < winnerCars.size() - 1; i++) {
			winners.append(winnerCars.get(i).name())
					.append(Constant.SPLIT_STRING)
					.append(Constant.SPACE);
		}
		winners.append(winnerCars.get(winnerCars.size() - 1).name());
		return winners;
	}
}
