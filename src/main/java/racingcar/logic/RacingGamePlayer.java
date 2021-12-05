package racingcar.logic;

import java.util.ArrayList;
import java.util.List;

import racingcar.Car;
import racingcar.utill.RandomNumberGenerator;

public class RacingGamePlayer {
	private static final int GO_FORWARD_BOUND = 4;

	public static List<Car> cars = new ArrayList<>();

	public List<String> playRacingGame(String[] names, int count) {
		generateCar(names);

		while (count != 0) {
			playOneRound();
			count--;
		}

		return judgeWinner();
	}

	private void generateCar(String[] names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	private void playOneRound() {
		for (Car c : cars) {
			int randomNum = getRandomNumber();
			if (randomNum >= GO_FORWARD_BOUND) {
				c.moveForward();
			}
		}

		displayRoundResult();
	}

	private int getRandomNumber() {
		return RandomNumberGenerator.generateRandomNumber();
	}

	private void displayRoundResult() {

	}

	private List<String> judgeWinner() {
		List<String> winnerNames = new ArrayList<>();

		for (Car c : cars) {
			if (c.isMaxPosition()) {
				winnerNames.add(c.getName());
			}
		}

		return winnerNames;
	}
}
