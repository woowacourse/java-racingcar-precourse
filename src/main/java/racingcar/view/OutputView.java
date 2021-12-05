package racingcar.view;

import java.util.List;

public class OutputView {
	public static void printCarsStatus(List<String> carsStatusByFormatter) {
		for (String carStatusByFormatter : carsStatusByFormatter) {
			System.out.println(carStatusByFormatter);
		}
		printBlankLine();
	}

	public static void printFinalCarWinners(List<String> winnerCarNames) {
		System.out.println("최종 우승자 : " + String.join(", ", winnerCarNames));
	}

	public static void printBlankLine() {
		System.out.println();
	}
}
