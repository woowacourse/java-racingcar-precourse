package racingcar.domain;

import racingcar.util.NumberGeneratePolicy;
import racingcar.util.RandomNumberGeneratePolicy;

public class RacingGame {
	private final Cars cars;
	private final Round round;
	private final NumberGeneratePolicy numberGeneratePolicy;

	public RacingGame(Cars cars, Round round, NumberGeneratePolicy numberGeneratePolicy) {
		this.cars = cars;
		this.round = round;
		this.numberGeneratePolicy = numberGeneratePolicy;
	}

	public RacingGame(String carsName, int round, NumberGeneratePolicy numberGeneratePolicy) {
		this(Cars.fromString(carsName), Round.fromInt(round), numberGeneratePolicy);
	}

	public static RacingGame createRacingGame(String carsName, int round) {
		return new RacingGame(carsName, round, new RandomNumberGeneratePolicy());
	}

	public RacingRecord race() {
		cars.driveAll(numberGeneratePolicy);
		return new RacingRecord(cars.getDriveRecord());
	}

	public boolean isContinue() {
		return round.hasNext();
	}

	public RacingResult getRacingResult() {
		return new RacingResult(cars.getWinners());
	}
}
