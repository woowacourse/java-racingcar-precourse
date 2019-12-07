package domain;

import java.util.List;

public class RacingCarGame {
	private final CarManager carManager;
	private final TrialCount trialCount;

	public RacingCarGame(List<String> carNames, int trialCount) {
		this.carManager = new CarManager(carNames);
		this.trialCount = new TrialCount(trialCount);
	}
}
