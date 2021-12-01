package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
	private List<Car> cars;
	private int round;

	public Race(List<Car> cars, int round) {
		this.cars = cars;
		this.round = round;
	}

	public void start() {
		for(int i = 0; i < round; i++) {
			cars.forEach(Car::moveOrStop);

			System.out.println(cars);
		}
	}

}
