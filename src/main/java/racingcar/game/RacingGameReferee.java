package racingcar.game;

import java.util.List;

import racingcar.Car;
import racingcar.utils.RandomNumbers;

public class RacingGameReferee {
	private static final int THRESHOLD = 4;

	public void race(List<Car> cars) {
		cars.stream()
			.forEach(car -> car.moveOrStop(RandomNumbers.getRandomNumber(), THRESHOLD));
	}
}
