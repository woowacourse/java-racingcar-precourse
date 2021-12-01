package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
	private static final int FORWARD_THRESHOLD_NUMBER = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public static boolean isForward(int randNo) {
		return randNo >= FORWARD_THRESHOLD_NUMBER;
	}

	public static List generateCars(String cars) {
		String[] str = cars.split(",");
		List<String> newList;
		newList = Arrays.asList(str);

		return newList;
	}

	public int getPosition() {
		return this.position;
	}

	public void forward() {
		this.position++;
	}
}
