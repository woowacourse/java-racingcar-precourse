package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

	private final String RESULT_MESSAGE = "실행 결과";

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
		printResult();
	}

	private void makeCarList() {
		for (String name : user.getNames()) {
			Car car = new Car(name);
			carList.add(car);
		}
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
}
