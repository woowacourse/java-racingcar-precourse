package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class User {
	private Scanner userInput;
	private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_MOVE_COUNT = "시도할 회수는 몇회인가요?";
	private static final String MOVE_COUNT_BE_POSITIVE = "시도 횟수는 음수일 수 없습니다.";
	private static final String NAME_LENGTH_BELOW_FIVE = "자동차 이름의 길이는 5자 이하만 가능합니다.";
	private static final String COMMA = ",";
	private static final int MAX_NAME_LENGTH = 5;

	User() {
		userInput = new Scanner(System.in);
	}

	public List<String> getCarNames() {
		List<String> carNames = new ArrayList<>();
		System.out.println(INPUT_CAR_NAMES);
		StringTokenizer tokenizer = new StringTokenizer(userInput.next(), COMMA);

		while (tokenizer.hasMoreTokens()) {
			String carName = tokenizer.nextToken();

			if (isNameLengthLonger(carName)) {
				return getCarNames();
			}

			carNames.add(carName);
		}

		return carNames;
	}

	private boolean isNameLengthLonger(String carName) {

		if (carName.length() > MAX_NAME_LENGTH) {
			System.out.println(NAME_LENGTH_BELOW_FIVE);
			return true;
		}

		return false;
	}

	public int getCarMoveCount() {
		int carMoveCount;

		do {
			System.out.println(INPUT_MOVE_COUNT);
			carMoveCount = Integer.parseInt(userInput.next());
		} while (isNegativeCount(carMoveCount));

		return carMoveCount;
	}

	private boolean isNegativeCount(int carMoveCount) {

		if (carMoveCount < 0) {
			System.out.println(MOVE_COUNT_BE_POSITIVE);
			return true;
		}

		return false;
	}
}
