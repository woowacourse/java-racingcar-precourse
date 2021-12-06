package racingcar.domain;

public class RacingCarGame {
	private final int roundNumber;
	private Cars cars;

	private RacingCarGame(int roundNumber, Cars cars) {
		this.roundNumber = roundNumber;
		this.cars = cars;
	}

	public static RacingCarGame generateGame(String roundNumber, Cars cars) {
		return new RacingCarGame(Integer.parseInt(roundNumber), cars);
	}

	private static void validate(String roundNumber) {}
}
