package racingcar.domain;

import java.util.List;

public class RacingResult {
	private List<Car> winners;

	public RacingResult(List<Car> winners) {
		this.winners = winners;
	}

	public List<Car> getWinners() {
		return winners;
	}
}
