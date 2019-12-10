package gameRunner;

import static view.OutputView.*;

import java.util.List;

import domain.CarCollection;

public class RacingGame {
	private CarCollection carCollection;
	private int tryCount;

	public RacingGame(List<String> name, int tryCount) {
		this.carCollection = new CarCollection(name);
		this.tryCount = tryCount;
	}

	public void runRaceAsTryCount() {
		showResultInfo();
		for (int i = 0; i < tryCount; i++) {
			carCollection.tryMoveCars();
			showRacingProcess(carCollection);
		}
		showRacingResultReport(carCollection);
	}

}
