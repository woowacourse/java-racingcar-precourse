package domain;

import java.util.ArrayList;
import java.util.List;

public class Entry {
	private static final String MOVE_LINE = "-";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
	private static final String CAR_POSITION_PRINT_FORMAT = "%s : %s\n";

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
			System.out.printf(CAR_POSITION_PRINT_FORMAT, car.getName(), toStringPosition(car.getPosition()));
		}

		System.out.println();
	}

	private String toStringPosition(int carPosition) {
		StringBuilder stringPosition = new StringBuilder();

		for (int i = 0; i < carPosition; ++i) {
			stringPosition.append(MOVE_LINE);
		}

		return stringPosition.toString();
	}

	public void printWhoWin() {
		StringBuilder winnerMessageBuilder = new StringBuilder();

		for (String carName : getFirstCarNames()) {
			winnerMessageBuilder.append(carName);
			winnerMessageBuilder.append(GameInputManager.COMMA);
		}

		winnerMessageBuilder.deleteCharAt(winnerMessageBuilder.length() - 1);
		System.out.println(winnerMessageBuilder.toString() + WINNER_MESSAGE);
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
