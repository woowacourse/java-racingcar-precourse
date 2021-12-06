package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.type.RangeType;
import racingcar.view.OutputView;

public class RacingGame {

	private final Cars cars;
	private int gameRound;

	public RacingGame(Cars cars, int gameRound) {
		this.cars = cars;
		this.gameRound = gameRound;
		OutputView.printStartRace();
	}

	public boolean isFinish() {
		return gameRound == RangeType.ZERO.getValue();
	}

	public void race() {
		decreaseGameRound();
		cars.race();
	}

	private void decreaseGameRound() {
		--gameRound;
	}

	public String findWinners() {
		List<String> winners = cars.getWinners();
		return winners.stream()
			.collect(Collectors.joining(", "));
	}
}
