package racingcar.domain;

import java.util.List;

public class RacingCar {
	private final List<Car> racingCars;

	public RacingCar(List<Car> racingCars) {
		this.racingCars = racingCars;
	}

	public void moveRacingCars() {
		for (Car car: racingCars) {
			car.moveCar();
		}
	}
}
