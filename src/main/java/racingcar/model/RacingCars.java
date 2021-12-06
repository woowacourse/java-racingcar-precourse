package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {

	public List<Car> racingCars = new ArrayList<>();

	public RacingCars(String[] requestCarsName) {
		Arrays.stream(requestCarsName).forEach(
			name -> racingCars.add(new Car(name))
		);
	}

	public void moveOrStopCars() {
		racingCars.forEach(
			Car::decideMoveOrStop
		);
	}
}
