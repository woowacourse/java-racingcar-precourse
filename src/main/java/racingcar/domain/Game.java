package racingcar.domain;

import java.util.List;

public class Game {
	private int trial;
	private List<Car> cars;
	private int trialNum = 0;

	public Game(int trial, List<Car> cars) {
		this.trial = trial;
		this.cars = cars;
	}
}
