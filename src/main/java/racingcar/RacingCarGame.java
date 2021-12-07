package racingcar;

import static constant.RacingCarGameMessage.*;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

	User user;
	Checker checker;
	List<Car> carList;
	Referee referee;

	RacingCarGame() {
		user = new User();
		checker = new Checker();
		carList = new ArrayList<>();
		referee = new Referee();
	}

	public void play() {
		askNamesUntilCorrect();
		askNumberOfTimesUntilCorrect();
		carList = Car.fromStringList(user.getNames());
		printResult();
		printWinner();
	}

	private void askNamesUntilCorrect() {
		String input;

		do {
			input = user.inputNames();
		} while (!checker.checkNames(input));

		user.setNames(input);
	}

	private void askNumberOfTimesUntilCorrect() {
		String input;

		do {
			input = user.inputNumberOfTimes();
		} while (!checker.checkNumberOfTimes(input));

		user.setNumberOfTimes(input);
	}

	private void printResult() {
		System.out.println(RESULT_MESSAGE);

		for (int i = 0; i < user.getNumberOfTimes(); i++) {

			for (Car car : carList) {
				car.goOrStop();
				car.printState();
			}

			System.out.println();
		}
	}

	private void printWinner() {
		String winnerNames = referee.sayWinnerNames(carList);
		System.out.println(WINNER_MESSAGE + COLON + winnerNames);
	}
}
