package racingcar.view;

import java.util.List;

import racingcar.Car;
import racingcar.logic.RacingGamePlayer;

public class OutputView {
	private static final String RESULT_MSG = "실행 결과";
	private static final String WINNER_MSG = "최종 우승자";

	public static void displayResultMsg() {
		System.out.println("\n" + RESULT_MSG);
	}

	public static void displayOneRoundResult() {
		for (Car car : RacingGamePlayer.cars) {
			displayCarPosition(car);
		}
		System.out.println();
	}

	private static void displayCarPosition(Car car) {
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void displayWinners(List<String> winnerNames) {
		System.out.print(WINNER_MSG + " : ");
		for (int i = 0; i < winnerNames.size(); i++) {
			System.out.print(winnerNames.get(i));

			if (i != winnerNames.size() - 1) {
				System.out.print(", ");
			}
		}
	}
}
