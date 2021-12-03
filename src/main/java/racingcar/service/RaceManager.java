package racingcar.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.Constants;
import racingcar.domain.Car;

public class RaceManager {

	public void move(List<Car> cars) {
		for(Car car : cars) {
			proceed(car);
		}
	}

	private void proceed(Car car) {
		int randomNumber = randomGenerate();
		if(proceed(randomNumber)) {
			car.increasePosition();
		}
	}

	private int randomGenerate() {
		return Randoms.pickNumberInRange(0, 9);
	}

	private boolean proceed(int number) {
		return number >= Constants.MOVE_NUMBER;
	}
}
