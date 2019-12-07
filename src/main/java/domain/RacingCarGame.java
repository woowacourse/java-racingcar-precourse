package domain;

import java.util.List;

public class RacingCarGame {
	private final CarManager carManager;
	private final TrialCount trialCount;

	public RacingCarGame(List<String> carNames, int trialCount) {
		this.carManager = new CarManager(carNames);
		this.trialCount = new TrialCount(trialCount);
	}

	public boolean hasNextRace() {
		return trialCount.hasNext();
	}

	public void race() {
		carManager.update();
		trialCount.next();
	}
}
