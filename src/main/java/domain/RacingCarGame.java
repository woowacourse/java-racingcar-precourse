package domain;

import java.util.List;
import java.util.stream.Collectors;

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

	public List<Car> getCars() {
		return carManager.getCars();
	}

	public List<String> getWinners() {
		return carManager.selectMaxPositionCars()
				.stream()
				.map(Car::getName)
				.collect(Collectors.toList());
	}
}
