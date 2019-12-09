package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {
	public static final String COMMA = ",";
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

	public static void main(String[] args) {
		User user = new User();
		runRacingGame(user);
	}

	private static void runRacingGame(User user) {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
		Entry entry = makeRacingEntry(getCarNameList(user.getCarNames()));

		System.out.println(INPUT_MOVE_COUNT_MESSAGE);
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

	private static List<String> getCarNameList(String carNames) {
		List<String> carNameList = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(carNames, COMMA);

		while (tokenizer.hasMoreTokens()) {
			carNameList.add(tokenizer.nextToken());
		}

		return carNameList;
	}
}
