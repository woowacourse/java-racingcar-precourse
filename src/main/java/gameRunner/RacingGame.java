package gameRunner;

import java.util.List;

import domain.CarCollection;

public class RacingGame {
	private CarCollection carCollection;
	private int tryCount;

	public RacingGame(List<String> name, int tryCount) {
		this.carCollection = new CarCollection(name);
		this.tryCount = tryCount;
	}

	private void runRace() {
		carCollection.tryMoveCars();
	}

	public void runRaceAsTryCount() {
		for (int i = 0; i < tryCount; i++) {
			runRace();
		}
	}
}
