package racingcar;

import static constant.RacingCarGameMessage.*;
import static constant.RacingCarGameRule.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void goOrStop() {
		int randomNumber = Randoms.pickNumberInRange(START_NUMBER_OF_RANGE, END_NUMBER_OF_RANGE);

		if (randomNumber >= START_NUMBER_OF_GO) {
			position++;
		}
	}

	public void printState() {
		String state = name + COLON;

		for (int i = 0; i < position; i++) {
			state += "-";
		}

		System.out.println(state);
	}

	public static List<Car> fromStringList(List<String> names) {
		List<Car> carList = new ArrayList<>();

		for (String name : names) {
			Car car = new Car(name);
			carList.add(car);
		}

		return carList;
	}

	public static String getWinnerNames(List<Car> carList) {
		List<Car> winnerList = Car.pickTheWinner(carList);
		String winnerNames = winnerList.get(0).name;

		for (int i = 1; i < winnerList.size(); i++) {
			winnerNames += DELIMITER + SPACE + winnerList.get(i).name;
		}

		return winnerNames;
	}

	public static List<Car> pickTheWinner(List<Car> carList) {
		List<Car> winnerList = new ArrayList<>();
		int winnerPosition = Car.maxPosition(carList);

		for (Car car : carList) {

			if (car.position == winnerPosition) {
				winnerList.add(car);
			}

		}

		return winnerList;
	}

	private static int maxPosition(List<Car> carList) {
		int maxPosition = 0;

		for (Car car : carList) {

			if (maxPosition < car.position) {
				maxPosition = car.position;
			}

		}
		return maxPosition;
	}
}
