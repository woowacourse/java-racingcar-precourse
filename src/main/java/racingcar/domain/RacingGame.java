package racingcar.domain;

import racingcar.util.RandomNumberGeneratePolicy;

public class RacingGame {
	private final Cars cars;
	private final int round;
	private final RandomNumberGeneratePolicy randomNumberGeneratePolicy;

	public RacingGame(Cars cars, int round, RandomNumberGeneratePolicy randomNumberGeneratePolicy) {
		this.cars = cars;
		this.round = round;
		this.randomNumberGeneratePolicy = randomNumberGeneratePolicy;
	}

	public RacingGame(String carsName, int round, RandomNumberGeneratePolicy randomNumberGeneratePolicy) {
		this(Cars.fromString(carsName), round, randomNumberGeneratePolicy);
	}

	public static RacingGame createRacingGame(String carsName, int round) {
		return new RacingGame(carsName, round, new RandomNumberGeneratePolicy());
	}

	public RacingRecord race() {
		cars.driveAll(randomNumberGeneratePolicy);
		return new RacingRecord(cars.getDriveRecord());
	}

	public boolean isContinue(int roundCount) {
		if (roundCount == round) {
			return false;
		}
		return true;
	}

	public RacingResult getRacingResult() {
		return new RacingResult(cars.getWinners());
	}
}
