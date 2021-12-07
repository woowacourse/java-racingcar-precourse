package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private static final RacingGame racingGame = new RacingGame();
	public static final String DELIMITER_FOR_NAMES = ", ";
	private Cars cars;

	private RacingGame() {
	}

	public void init() {
		cars = null;
	}

	public static RacingGame getInstance() {
		return racingGame;
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
			.collect(Collectors.joining(DELIMITER_FOR_NAMES));
	}
}
