package racingcar.domain;

import java.util.List;

import racingcar.util.RandomNumberGeneratePolicy;

public class Cars {
	private final List<Car> cars;
	private final RandomNumberGeneratePolicy randomNumberGeneratePolicy;

	public Cars(List<Car> cars, RandomNumberGeneratePolicy numberGeneratePolicy) {
		this.cars = cars;
		this.randomNumberGeneratePolicy = numberGeneratePolicy;
	}

	public void driveAll() {
		cars.forEach(car -> car.drive(randomNumberGeneratePolicy.generateNumber()));
	}
}
