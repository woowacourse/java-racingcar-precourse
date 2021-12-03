package racingcar.racinggame;

import racingcar.Car;
import racingcar.user.Input;

public class Game {
	private final Input input;

	public Game() {
		input = new Input();
	}

	public void start() {
		String[] carNames = input.inputCarNames();
		Car[] cars = createCars(carNames);

		String round = input.inputRound();
	}

	private Car[] createCars(String[] carNames) {
		Car[] cars = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			cars[i] = new Car(carNames[i]);
		}
		return cars;
	}
}
