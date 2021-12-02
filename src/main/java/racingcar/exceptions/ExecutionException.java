package racingcar.exceptions;

public class ExecutionException {

	private static String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자여야 한다.\n";
	private static String ERROR_MESSAGE_NOT_POSITIVE = "[ERROR] 시도 횟수는 0보다 큰 정수이어야 한다.\n";

	//실행 횟수에 대한 예외처리
	//실행 횟수는 0보다 큰 정수이어야함
	public static void executionException(String userProcess) {
		try {
			int executionTime = Integer.parseInt(userProcess);
			isPositive(executionTime);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMBER);
		}
	}

	private static void isPositive(int process) {
		if (process <= 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NOT_POSITIVE);
		}
	}
}
