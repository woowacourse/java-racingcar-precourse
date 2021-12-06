package racingcar.domain;

public class RacingCarGame {
	private final int roundNumber;
	private Cars cars;

	private static final String NUMBER_GT_ONE_FILTER = "[1-9][0-9]*";

	private static final String ROUND_NUMBER_ERROR_MESSAGE = "[ERROR] 1 이상의 수를 입력해주세요";

	private RacingCarGame(int roundNumber, Cars cars) {
		this.roundNumber = roundNumber;
		this.cars = cars;
	}

	public static RacingCarGame generateGame(String roundNumber, Cars cars) {
		validate(roundNumber);
		return new RacingCarGame(Integer.parseInt(roundNumber), cars);
	}

	private static void validate(String roundNumber) {
		if (!isNumberGreaterThanOne(roundNumber)) {
			throw new IllegalArgumentException(ROUND_NUMBER_ERROR_MESSAGE);
		}
	}

	private static boolean isNumberGreaterThanOne(String roundNumber) {
		return roundNumber.matches(NUMBER_GT_ONE_FILTER);
	}
}
