package racingcar.handler;

import static racingcar.utils.Constant.*;

import java.util.List;

import racingcar.domain.Car;

public class PrintHandler {
	public static void printInputNameMsg() {
		System.out.println(INPUT_NAME_MSG);
	}

	public static void printErrorMsg(Exception exception) {
		System.out.println(exception.getMessage());
	}

	public static void printInputNumberMsg() {
		System.out.println(INPUT_NUMBER_MSG);
	}

	public static void printResultMsg() {
		System.out.println(RESULT_MSG);
	}

	public static void printBlank() {
		System.out.println();
	}

	public static void printCar(Car car) {
		StringBuilder sb = new StringBuilder(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			sb.append("-");
		}
		System.out.println(sb);
	}

	public static void printWinner(Car winner) {
		System.out.println(WINNER_MSG + winner.getName());
	}

	public static void printWinners(List<Car> winners) {
		StringBuilder sb = new StringBuilder(WINNER_MSG);
		winners.forEach(car -> {
			sb.append(car.getName()).append(", ");
		});
		String result = sb.toString().trim();
		System.out.println(result.substring(0, sb.length() - 2));
	}
}
