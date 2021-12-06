package racingcar;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int THRESHOLD = 4;

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
		String[] carInput = Console.readCar();
		cars = Arrays.stream(carInput)
			.map(Car::new)
			.toArray(Car[]::new);
	}

	private void setTurnFromInput() {
		turn = Console.readTurn();
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
		if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= THRESHOLD) {
			car.moveForward();
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
	}

	private void printWinners() {
		Printer.printCarsAt(cars, maxPosition);
	}
}
