package domain;

import java.util.ArrayList;
import java.util.List;

public class Entry {
	private List<Car> racingEntry;

	Entry(List<Car> racingEntry) {
		this.racingEntry = racingEntry;
	}

	public void moveEachCar() {

		for (Car car : racingEntry) {
			car.moveCar();
		}

	}

	public void printEachCarPosition() {

		for (Car car : racingEntry) {
			System.out.printf("%s : %s\n", car.getName(), toStringPosition(car.getPosition()));
		}

	}

	private String toStringPosition(int carPosition) {
		StringBuilder stringPosition = new StringBuilder();

		for (int i = 0; i < carPosition; ++i) {
			stringPosition.append("-");
		}

		return stringPosition.toString();
	}

	public void printWhoWin() {
		StringBuilder winnerMessageBuilder = new StringBuilder();

		for (String carName : getFirstCarNames()) {
			winnerMessageBuilder.append(carName);
			winnerMessageBuilder.append(',');
		}

		winnerMessageBuilder.deleteCharAt(winnerMessageBuilder.length() - 1);

		System.out.println(winnerMessageBuilder.toString());
	}

	private List<String> getFirstCarNames() {
		List<String> firstCarNames = new ArrayList<>();
		int firstPosition = getFirstPosition();

		for (Car car : racingEntry) {

			if (car.getPosition() == firstPosition) {
				firstCarNames.add(car.getName());
			}

		}

		return firstCarNames;
	}

	private int getFirstPosition() {
		int position = Car.START_POSITION;

		for (Car car : racingEntry) {

			if (position < car.getPosition()) {
				position = car.getPosition();
			}

		}

		return position;
	}
}
