package racingcar.domain;

import java.util.Map;

public class Round {
	private Map<String, Integer> roundResult;

	public Round(Cars cars) {
		makeRoundResult(cars);
	}

	public void makeRoundResult(Cars cars) {
		this.roundResult = cars.makeRoundResult();
	}
}
