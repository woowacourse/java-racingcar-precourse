package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

	private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_GAME_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String GAME_RESULT_MESSAGE = "실행 결과";
	private static final String NEWLINE = "\n";
	private static final String COLON = " : ";
	private static final String DASH = "-";
	private static final String WINNER = "최종 우승자";

	public static void printInputGameRound() {
		print(INPUT_GAME_ROUND_MESSAGE);
	}

	public static void printInputCarName() {
		print(INPUT_CAR_NAME_MESSAGE);
	}

	public static void printException(Exception exception) {
		print(exception.getMessage());
	}

	private static void print(String message) {
		System.out.println(message);
	}

	public static void printRaceProgress(Cars cars) {
		StringBuilder raceProgress = new StringBuilder();
		for (Car car : cars.getCars()) {
			raceProgress.append(car.getName() + COLON + getCarPositionMark(car.getPosition()) + NEWLINE);
		}
		raceProgress.append(NEWLINE);
		print(raceProgress.toString());
	}

	private static String getCarPositionMark(int position) {
		StringBuilder positionMark = new StringBuilder();
		while (position-- > 0) {
			positionMark.append(DASH);
		}
		return positionMark.toString();
	}

	public static void printStartRace() {
		print(NEWLINE + GAME_RESULT_MESSAGE);
	}
}
