package racingcar.logic;

import java.util.ArrayList;
import java.util.List;

import racingcar.Car;
import racingcar.utill.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RacingGamePlayer {
	private static final int GO_FORWARD_BOUND = 4;

	public static List<Car> cars = new ArrayList<>();

	public void playRacingGame(String[] names, int count) {
		generateCar(names);
		OutputView.displayResultMsg();

		while (count != 0) {
			playOneRound();
			count--;
		}
	}

	private void generateCar(String[] names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	private void playOneRound() {
		for (Car car : cars) {
			int randomNum = getRandomNumber();
			if (randomNum >= GO_FORWARD_BOUND) {
				car.moveForward();
			}
		}

		displayRoundResult();
	}

	private int getRandomNumber() {
		return RandomNumberGenerator.generateRandomNumber();
	}

	private void displayRoundResult() {
		OutputView.displayOneRoundResult();
	}

	public List<String> judgeWinner() {
		List<String> winnerNames = new ArrayList<>();

		for (Car car : cars) {
			if (car.isMaxPosition()) {
				winnerNames.add(car.getName());
			}
		}

		return winnerNames;
	}
}
