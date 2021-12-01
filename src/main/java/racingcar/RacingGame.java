package racingcar;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
	private Car[] cars;
	private int turn;
	private int maxPosition;

	public void start() {
		setCarsFromInput();
		setTurnFromInput();
		startRace();
		printWinners();
	}

	private void setCarsFromInput() {
		String[] carInput = Request.carInput();
		cars = Arrays.stream(carInput)
			.map(Car::new)
			.toArray(Car[]::new);
	}

	private void setTurnFromInput() {
		turn = Request.turnInput();
	}

	private void startRace() {
		for (int i = 0; i < turn; i++) {
			moveCarsRandomly();
			Printer.printProgress(cars);
		}
	}

	private void moveCarsRandomly() {
		for (Car car : cars) {
			moveCarRandomly(car);
		}
	}

	private void moveCarRandomly(Car car) {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			car.moveForward();
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
	}

	private void printWinners() {
		Printer.printWinnersAt(cars, maxPosition);
	}
}
