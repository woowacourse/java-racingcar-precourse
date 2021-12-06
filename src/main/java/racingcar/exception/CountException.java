package racingcar.exception;

public class CountException {

	private static final String COUNT_EMPTY_ERROR_MASSAGE = "[ERROR] 시도할 회수가 빈칸입니다! 다시 입력해주세요.";
	private static final String COUNT_NOT_INT_ERROR_MASSAGE = "[ERROR] 숫자가 아닌 값이 입력되었습니다! 다시 입력해주세요.";
	private static final String COUNT_UNDER_ONE_ERROR_MASSAGE = "[ERROR] 1보다 작을 경우 게임을 진행할 수 없습니다! 다시 입력해주세요.";
	private static final int COUNT_MINIMUM_LIMIT = 1;

	public static void checkCountException(String count) {
		checkEmptyCount(count);
		checkCountIsInt(count);
		checkCountIsLowerOne(Integer.parseInt(count));
	}

	private static void checkEmptyCount(String count) {
		if (count == null || count.isEmpty() ) {
			throw new IllegalArgumentException(COUNT_EMPTY_ERROR_MASSAGE);
		}

	}

	private static void checkCountIsInt(String count) {
		try {
			Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(COUNT_NOT_INT_ERROR_MASSAGE);
		}
	}

	private static void checkCountIsLowerOne(int count) {
		if (count < COUNT_MINIMUM_LIMIT) {
			throw new IllegalArgumentException(COUNT_UNDER_ONE_ERROR_MASSAGE);
		}
	}
}
