package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	public static final Predicate<Integer> MOVE_CONDITION = i -> i >= 4;
	public static final Supplier<Integer> MOVE_VALUE = () -> Randoms.pickNumberInRange(1, 9);

	private List<Car> cars;

	public Game(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void play(Supplier<Integer> value, Predicate<Integer> condition) {
		for (Car car : cars) {
			if (condition.test(value.get())) {
				car.move();
			}
		}
	}

	public List<Car> winners() {
		Collections.sort(cars);
		List<Car> winners = new ArrayList<>();
		int maxPosition = cars.get(0).getPosition();
		for (Car car : cars) {
			if (maxPosition == car.getPosition()) {
				winners.add(car);
			}
		}
		return winners;
	}
}
