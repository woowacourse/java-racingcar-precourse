package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

	private final String RESULT_MESSAGE = "실행 결과";
	private final String WINNER_MESSAGE = "최종 우승자 : ";

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
		printWinner();
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

	private void printWinner() {
		carList.sort(Car.winComparator);
		Car winner = carList.get(0);
		String winnerNames = winner.getName();
		for (int i = 1; i < carList.size(); i++) {
			if (winner.draw(carList.get(i))) {
				winnerNames += ", " + carList.get(i).getName();
				continue;
			}
			break;
		}
		System.out.println(WINNER_MESSAGE + winnerNames);
	}
}
