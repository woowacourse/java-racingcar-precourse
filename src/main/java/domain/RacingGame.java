package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private static final String RACING_RESULT = "실행결과";

	public static void main(String[] args) {
		GameInputManager gameInputManager = new GameInputManager();
		runRacingGame(gameInputManager);
	}

	private static void runRacingGame(GameInputManager gameInputManager) {
		Entry entry = makeRacingEntry(gameInputManager.getCarNames());
		int carMoveCount = gameInputManager.getCarMoveCount();

		System.out.println(RACING_RESULT);

		for (int i = 0; i < carMoveCount; ++i) {
			entry.moveEachCar();
			entry.printEachCarPosition();
		}

		entry.printWhoWin();
	}

	private static Entry makeRacingEntry(List<String> carNameList) {
		List<Car> carList = new ArrayList<>();

		for (String carName : carNameList) {
			carList.add(new Car(carName));
		}

		return new Entry(carList);
	}
}
