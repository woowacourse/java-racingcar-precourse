package racingcar.view;

import static racingcar.constant.GameConstants.*;

import racingcar.domain.RacingCar;

public class OutputView {

	public static void printAskingCarNames() {
		System.out.println(ASKING_CAR_NAME_MESSAGE);
	}

	public static void printAskingRounds() {
		System.out.println(ASKING_TRY_ROUNDS_MESSAGE);
	}

	public static void printGameExecutionResult() {
		System.out.println(GAME_EXECUTION_RESULT_MESSAGE);
	}

	public static void printWinner(StringBuilder winner) {
		System.out.println(WINNER_MESSAGE + winner);
	}

	public static void printCarLocation(RacingCar racingCar) {
		System.out.print(racingCar.getCarName() + " : ");
		for (int i = 0; i < racingCar.getLocation(); i++) {
			System.out.print(CAR_SHAPE);
		}
		System.out.println();
	}
}
