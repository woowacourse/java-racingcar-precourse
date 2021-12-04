package racingcar.domain;

import java.util.List;

public class Game {
	private final int trial;
	private final List<Car> cars;
	private int trialNum = 0;

	public Game(List<Car> cars, int trial) {
		this.cars = cars;
		this.trial = trial;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void increaseTrialNum() {
		this.trialNum += 1;
	}

	public boolean checkReachTrialNumToTrial() {
		return this.trial == this.trialNum;
	}
}
