package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	public static void main(String[] args) {
		User user = new User();
		runRacingGame(user);
	}

	private static void runRacingGame(User user) {
		Entry entry = makeRacingEntry(user.getCarNames());
		int carMoveCount = user.getCarMoveCount();

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
