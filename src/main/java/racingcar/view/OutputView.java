package racingcar.view;

import static constants.RacingCarConstant.*;

import java.util.List;

public class OutputView {
	public static void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}

	public static void printExecutionMessage() {
		System.out.println(EXECUTION_RESULT_MESSAGE);
	}

	public static void printCarName(String carName) {
		System.out.print(carName + COLON);
	}

	public static void printCarPosition(Integer position) {
		StringBuilder carPosition = new StringBuilder();
		for (int i = 0; i < position; i++) {
			carPosition.append(PROGRESS_BAR);
		}
		System.out.println(carPosition);
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printWinner(List<String> winnerNames) {
		StringBuilder resultMessage = new StringBuilder();
		resultMessage.append(FINAL_WINNER_MESSAGE);
		for (int idx = 0; idx < winnerNames.size() - 1; idx++) {
			resultMessage.append(winnerNames.get(idx));
			resultMessage.append(COMMA);
		}
		resultMessage.append(winnerNames.get(winnerNames.size() - 1));
		System.out.println(resultMessage);
	}
}
