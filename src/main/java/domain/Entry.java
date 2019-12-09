package domain;

import java.util.List;

public class Entry {
	private List<Car> racingEntry;

	Entry(List<Car> racingEntry) {
		this.racingEntry = racingEntry;
	}

	public void printEachCarPosition() {

		for (Car car : racingEntry) {
			System.out.printf("%s : %s\n", car.getName(), toStringPosition(car.getPosition()));
		}

	}

	private String toStringPosition(int carPosition) {
		String stringPosition = "";

		for (int i = 0; i < carPosition; ++i) {
			stringPosition.concat("-");
		}

		return stringPosition;
	}
}
