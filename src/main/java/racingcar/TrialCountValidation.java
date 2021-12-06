package racingcar;

public class TrialCountValidation {
	private static final int MIN_BOUND = 1;
	private static final String NOT_NUMBER_MESSAGE = "시도 회수가 정수인 숫자가 아닙니다.";
	private static final String NOT_IN_RANGE_MESSAGE = "시도 회수가 1 이상이 아닙니다.";

	public static void isValidateTrialCount(String trialCount) {
		isValidateRange(isValidateNumber(trialCount));
	}

	private static int isValidateNumber(String trialCount) {
		try {
			return Integer.parseInt(trialCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
		}
	}

	private static void isValidateRange(int trialCount) {
		if (trialCount < MIN_BOUND) {
			throw new IllegalArgumentException(NOT_IN_RANGE_MESSAGE);
		}
	}
}
