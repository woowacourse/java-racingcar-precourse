package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

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
		int maxPosition = Collections.max(cars.stream().map(Car::getPosition)
			.collect(Collectors.toList()));

		List<Car> winners = cars.stream().filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());

		String winnersOutput = Const.WINNER_MESSAGE
			+ winners.stream().map(Car::getName)
			.collect(Collectors.joining(", "));

		System.out.println(winnersOutput);
	}

	private void printRoundResult() {
		cars.forEach(Car::printPosition);
		System.out.println();
	}
}
