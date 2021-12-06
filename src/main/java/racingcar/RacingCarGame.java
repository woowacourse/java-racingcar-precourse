package racingcar;

import static constant.RacingCarGameMessage.*;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

	User user;
	List<Car> carList;

	RacingCarGame() {
		user = new User();
		carList = new ArrayList<>();
	}

	public void Play() {
		user.askNamesUntilCorrect();
		user.askNumberOfTimesUntilCorrect();
		carList = Car.fromString(user.getNames());
		printResult();
		printWinner();
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
