package racingcar;

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
		makeCarList();
	}

	private void makeCarList() {
		for (String name : user.getNames()) {
			Car car = new Car(name);
			carList.add(car);
		}
	}
}
