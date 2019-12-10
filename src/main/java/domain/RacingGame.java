package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {
	public static final String COMMA = ",";

	public static void main(String[] args) {
		User user = new User();
		runRacingGame(user);
	}

	private static void runRacingGame(User user) {
		Entry entry = makeRacingEntry(getCarNameList(user.getCarNames()));
		int carMoveCount = user.getCarMoveCount();

		for (int i = 0; i < carMoveCount; ++i) {
			entry.moveEachCar();
			entry.printEachCarPosition();
		}

		entry.printWhoWin();
	}

	private static boolean isNegativeCount(int carMoveCount) {

		if (carMoveCount < 0) {
			return true;
		}

		return false;
	}

	private static Entry makeRacingEntry(List<String> carNameList) {
		List<Car> carList = new ArrayList<>();

		for (String carName : carNameList) {
			carList.add(new Car(carName));
		}

		return new Entry(carList);
	}

	private static List<String> getCarNameList(String carNames) {
		List<String> carNameList = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(carNames, COMMA);

		while (tokenizer.hasMoreTokens()) {
			carNameList.add(tokenizer.nextToken());
		}

		return carNameList;
	}
}
