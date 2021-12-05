package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
	private List<Car> cars;
	private int round;

	public Race(List<Car> cars, int round) {
		this.cars = cars;
		this.round = round;
	}

	public void start() {
		System.out.println(Const.RACE_RESULT_MESSAGE);
		for (int i = 0; i < round; i++) {
			cars.forEach(Car::moveOrStop);
			printRoundResult();
		}
	}

	public void printWinners() {
		int maxPosition = getMaxPosition();

		List<String> winnerNames = getWinnerNames(maxPosition);

		String winnersOutputMessage = Const.WINNER_MESSAGE
			+ String.join(Const.WINNER_SEPARATOR, winnerNames);

		System.out.println(winnersOutputMessage);
	}

	private void printRoundResult() {
		cars.forEach(Car::printPosition);
		System.out.println();
	}

	private List<String> getWinnerNames(int maxPosition) {
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return Collections.max(cars.stream().map(Car::getPosition)
			.collect(Collectors.toList()));
	}
}
