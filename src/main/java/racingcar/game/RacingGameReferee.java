package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.utils.RandomNumbers;

public class RacingGameReferee {
	private static final int THRESHOLD = 4;

	public void race(List<Car> cars) {
		cars.stream()
			.forEach(car -> car.moveOrStop(RandomNumbers.getRandomNumber(), THRESHOLD));
	}

	public List<Car> getGameResult(List<Car> cars) {
		Integer winCount = cars.stream()
			.map(Car::getPosition)
			.max(Integer::compare)
			.get();

		return cars.stream()
			.filter(car -> car.getPosition() == winCount)
			.collect(Collectors.toList());
	}
}
