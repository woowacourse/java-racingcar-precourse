package racingcar.racinggame;

import racingcar.Car;
import racingcar.user.Input;
import racingcar.user.Output;

public class Game {
	private final Input input;
	private final Output output;
	private int highScore;

	public Game() {
		input = new Input();
		output = new Output();
	}

	public void start() {
		String[] carNames = input.inputCarNames();
		Car[] cars = createCars(carNames);

		String round = input.inputRound();
		output.printRoundResult(round, cars);

		getHighScore(cars);
	}

	private Car[] createCars(String[] carNames) {
		Car[] cars = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			cars[i] = new Car(carNames[i]);
		}
		return cars;
	}

	private void getHighScore(Car[] cars) {
		for (Car car : cars) {
			isHighScore(car);
		}
	}

	private void isHighScore(Car car) {
		if (car.getPosition() > highScore) {
			highScore = car.getPosition();
		}
	}
}
