package racingcar;

import static constant.RacingCarGameMessage.*;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

	User user;
	Checker checker;
	List<Car> carList;

	RacingCarGame() {
		user = new User();
		checker = new Checker();
		carList = new ArrayList<>();
	}

	public void Play() {
		askNamesUntilCorrect();
		askNumberOfTimesUntilCorrect();
		carList = Car.fromStringList(user.getNames());
		printResult();
		printWinner();
	}

	private void askNamesUntilCorrect() {
		String input = user.inputNames();
		while (!checker.checkNames(input)) {
			input = user.inputNames();
		}
		user.setNames(input);
	}

	private void askNumberOfTimesUntilCorrect() {
		String input = user.inputNumberOfTimes();
		while (!checker.checkNumberOfTimes(input)) {
			input = user.inputNumberOfTimes();
		}
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
		List<Car> winnerList = Car.pickTheWinner(carList);
		String winnerNames = winnerList.get(0).getName();
		for (int i = 1; i < winnerList.size(); i++) {
			winnerNames += DELIMITER + SPACE + winnerList.get(i).getName();
		}
		System.out.println(WINNER_MESSAGE + COLON + winnerNames);
	}
}
