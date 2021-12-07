package racingcar.exceptions;

import static racingcar.constant.StringConstant.*;

public class ExecutionException {
	//실행 횟수에 대한 예외처리
	//실행 횟수는 0보다 큰 정수이어야함
	public static void executionException(String userProcess) {
		try {
			int executionTime = Integer.parseInt(userProcess);
			isPositive(executionTime);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_PREFIX + EXECUTE_NOT_NUMBER);
		}
	}

	private static void isPositive(int process) {
		if (process <= 0) {
			throw new IllegalArgumentException(ERROR_PREFIX + EXECUTE_NOT_POSITIVE);
		}
	}
}
