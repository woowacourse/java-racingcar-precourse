package racingcar.domain;

import static racingcar.utils.Validator.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " : ");
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	public void moveOrStop(int randomNumber) {
		if (validateCarMoveCondition(randomNumber)) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public static void sortingByPosition(List<Car> carList) {
		Collections.sort(carList, new ComparatorByPosition());
	}

	static class ComparatorByPosition implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o2.position - o1.position;
		}
	}

}
