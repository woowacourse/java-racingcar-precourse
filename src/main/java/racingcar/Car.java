package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private final int START_NUMBER_OF_RANGE = 0;
	private final int END_NUMBER_OF_RANGE = 9;
	private final int START_NUMBER_OF_GO = 4;

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
		String state = name + " : ";
		for (int i = 0; i < position; i++) {
			state += "-";
		}
		System.out.println(state);
	}

	public boolean draw(Car other) {
		if (this.position == other.position) {
			return true;
		}
		return false;
	}

	public static List<Car> fromString(List<String> names) {
		List<Car> carList = new ArrayList<>();
		for (String name : names) {
			Car car = new Car(name);
			carList.add(car);
		}
		return carList;
	}

	public static Comparator<Car> winComparator = new Comparator<Car>() {
		@Override
		public int compare(Car car1, Car car2) {
			return car2.position - car1.position;
		}
	};
}
