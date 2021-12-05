package racingcar.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCars {
	private final List<Car> cars;

	public RacingCars(List<Car> cars) {
		this.cars = cars;
	}

	public void go(){
		cars.forEach(Car::go);
	}
}
