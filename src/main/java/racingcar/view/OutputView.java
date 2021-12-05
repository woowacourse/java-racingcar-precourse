package racingcar.view;

import java.util.List;

public class OutputView {
	private static final String FINAL_WINNER_TITLE_MESSAGE = "최종 우승자 : ";

	public static void printCarsStatus(List<String> carsStatusByFormatter) {
		for (String carStatusByFormatter : carsStatusByFormatter) {
			System.out.println(carStatusByFormatter);
		}
		printBlankLine();
	}

	public static void printFinalCarWinners(List<String> winnerCarNames) {
		System.out.println(FINAL_WINNER_TITLE_MESSAGE + String.join(", ", winnerCarNames));
	}

	public static void printBlankLine() {
		System.out.println();
	}
}
