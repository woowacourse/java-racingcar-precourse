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

	public String getName() {
		return name;
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

	public boolean isSamePosition(int position) {

		if (this.position == position) {
			return true;
		}

		return false;
	}

	public static int maxPosition(List<Car> carList) {
		int maxPosition = 0;

		for (Car car : carList) {

			if (maxPosition < car.position) {
				maxPosition = car.position;
			}

		}
		return maxPosition;
	}

	public static List<Car> fromStringList(List<String> names) {
		List<Car> carList = new ArrayList<>();

		for (String name : names) {
			Car car = new Car(name);
			carList.add(car);
		}

		return carList;
	}
}
