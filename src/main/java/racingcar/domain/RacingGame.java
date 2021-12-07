package racingcar.domain;

public class RacingGame {
	private static final RacingGame racingGame = new RacingGame();
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
}
