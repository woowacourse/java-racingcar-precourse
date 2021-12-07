package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class RacingCarGame {
	private int leftRounds;
	private Cars cars;

	private static final String NUMBER_GT_ONE_FILTER = "[1-9][0-9]*";

	private static final String ROUND_NUMBER_ERROR_MESSAGE = "[ERROR] 1 이상의 수를 입력해주세요";

	private RacingCarGame(int leftRounds, Cars cars) {
		this.leftRounds = leftRounds;
		this.cars = cars;
	}

	public static RacingCarGame generateGame(String roundNumber, Cars cars) {
		validateRoundNumber(roundNumber);
		return new RacingCarGame(Integer.parseInt(roundNumber), cars);
	}

	private static void validateRoundNumber(String roundNumber) {
		if (!isNumberGreaterThanOne(roundNumber)) {
			throw new IllegalArgumentException(ROUND_NUMBER_ERROR_MESSAGE);
		}
	}

	private static boolean isNumberGreaterThanOne(String roundNumber) {
		return roundNumber.matches(NUMBER_GT_ONE_FILTER);
	}

	public void startRound() {
		cars.moveCars();
		endRound();
	}

	private void endRound() {
		leftRounds--;
	}

	public boolean isGameEnd() {
		return leftRounds == 0;
	}

	public RoundStatus generateRoundStatus() {
		Map<String, Integer> hashMap = new HashMap<>();
		for (Car car : cars.getCars()) {
			hashMap.put(car.getName(), car.getPosition());
		}
		return new RoundStatus(hashMap);
	}
}
