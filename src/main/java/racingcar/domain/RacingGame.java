package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.Constant;

public class RacingGame {
	private static final RacingGame racingGame = new RacingGame();
	private Cars cars;

	private RacingGame() {
	}

	public static RacingGame getInstance() {
		return racingGame;
	}

	public void init() {
		cars = null;
	}

	public void insert(Cars cars) {
		this.cars = cars;
	}

	public void start() {
		this.cars.moveCars();
	}

	public String getResults() {
		return this.cars.getResults();
	}

	public String findNameOfWinners() {
		List<Car> CarOfWinners = this.cars.findWinners();
		return CarOfWinners.stream()
			.map(Car::toString)
			.collect(Collectors.joining(Constant.DELIMITER_FOR_NAMES));
	}
}
