package racingcar.domain;

import java.util.List;

public class Game {
	private List<Car> carList;

	public Game(List<Car> carList) {
		this.carList = carList;
	}

	public List<Car> getCarList() {
		return carList;
	}
}
