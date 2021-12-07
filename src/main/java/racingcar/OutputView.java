package racingcar;

import java.util.List;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";

	public void printCarsPosition(Cars cars) {
		cars.printPosition();
		System.out.println();
	}

	public void printResultMessage() {
		System.out.println();
		System.out.println(RESULT_MESSAGE);
	}

	public void printWinners(List<String> winners) {
		System.out.println(WINNER_MESSAGE + String.join(", ", winners));
	}
}
