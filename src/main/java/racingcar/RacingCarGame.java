package racingcar;

import java.util.List;

public class RacingCarGame {

	User user;
	List<Car> carList;

	RacingCarGame() {
		user = new User();
	}

	public void Play() {
		user.askNamesUntilCorrect();
		user.askNumberOfTimesUntilCorrect();
	}
}
