package racingcar.view;

import static racingcar.resource.MessageResoruce.*;

import java.util.List;

import racingcar.domain.Cars;

public class OutputView {
	private OutputView() {}

	public static void printMessage(final String message) {
		System.out.print(message);
	}

	public static void printlnMessage(final String message) {
		System.out.println(message);
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printCarPosition(final Cars cars) {
		printlnMessage(OUTPUT_RESULT);
		cars.getCars().forEach(car -> {
			printMessage(car.getName() + OUTPUT_COLON);

			for (int i = 0; i < car.getPosition(); i++) {
				printMessage(OUTPUT_LINE);
			}

			printNewLine();
		});
	}

	public static void printWinners(final List<String> winners) {
		printMessage(OUTPUT_WINNER);
		printlnMessage(String.join(OUTPUT_DELIMETER, winners));
	}
}
