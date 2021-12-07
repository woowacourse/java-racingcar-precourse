package racingcar.model;

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

	public void play(Predicate<Integer> condition, Supplier<Integer> value) {
		for (Car car : cars) {
			if (condition.test(value.get())) {
				car.move();
			}
		}
	}
}
