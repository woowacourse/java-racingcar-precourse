package view;

import java.util.StringJoiner;

public class Display {
	private static final int FIRST_CAR_INDEX = 0;
	private static final int START_CAR_POSITION = 0;
	private static final int FIRST_WINNER_INDEX = 0;
	private static final String COLON = " : ";
	private static final String HYPHEN = "-";
	private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String EXECUTION_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";

	private Display() {
	}

	public static void askInputRacingCarNames() {
		System.out.println(CAR_INPUT_MESSAGE);
	}

	public static void askInputNumberOfCarRaces() {
		System.out.println(TRY_COUNT_MESSAGE);
	}

	public static void showExecutionResult() {
		System.out.println();
		System.out.println(EXECUTION_MESSAGE);
	}

	public static void showRacingCarNowPositions(String[] carNames, int[] carPositions) {
		for (int index = FIRST_CAR_INDEX; index < carNames.length; index++) {
			showRacingCarNameAndPosition(carNames[index], carPositions[index]);
		}
		System.out.println();
	}

	private static void showRacingCarNameAndPosition(String carName, int carPosition) {
		System.out.print(carName + COLON);
		for (int index = START_CAR_POSITION; index < carPosition; index++) {
			System.out.print(HYPHEN);
		}
		System.out.println();
	}

	public static void showWinnerMessage(String[] racingCarGameWinners) {
		StringJoiner racingCarGameWinner = new StringJoiner(", ");
		System.out.print(WINNER_MESSAGE);
		for (int index = FIRST_WINNER_INDEX; index < racingCarGameWinners.length; index++) {
			racingCarGameWinner.add(racingCarGameWinners[index]);
		}
		System.out.println(racingCarGameWinner);
	}
}
