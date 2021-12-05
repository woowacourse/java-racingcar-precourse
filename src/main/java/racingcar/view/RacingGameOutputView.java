package racingcar.view;

import static racingcar.constants.HostMessages.*;

import java.util.List;

import racingcar.domain.Car;

public class RacingGameOutputView {
	private static final RacingGameOutputView racingGameOutputView = new RacingGameOutputView();

	private RacingGameOutputView() {
	}

	public static RacingGameOutputView getRacingGameOutputView() {
		return racingGameOutputView;
	}

	public void printMovementStart() {
		System.out.println(MOVEMENT_RESULT_START_SENTENCE);
	}

	public void printMovement(List<Car> carList) {
		for (Car car : carList) {
			System.out.println(car.getName() + " : " + car.getDashedPosition());
		}
		System.out.println();
	}

	public void printWinners(List<String> winners) {
		System.out.println(FINAL_RESULT_MESSAGE + String.join(", ", winners));
	}
}
