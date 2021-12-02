package racingcar.exceptions;

public class ProcessException {

	private static String ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.\n";

	//실행 횟수에 대한 예외처리
	//실행 횟수는 0보다 큰 정수이어야함
	public static void processException(String userProcess) {
		try {
			int process = Integer.parseInt(userProcess);
			isPositive(process);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

	private static void isPositive(int process) {
		if (process < 0) {
			throw new NumberFormatException();
		}
	}
}
