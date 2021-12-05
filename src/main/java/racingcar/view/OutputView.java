package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class OutputView {
	private static final String READ_CAR_NAMES_MASSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String READ_RACING_ROUND_MASSAGE = "시도할 회수는 몇회인가요?";
	private static final String START_ROUND_MASSAGE = "실행 결과";
	private static final String CAR_STATE = "%s : %s";
	private static final String WINNERS_FORM = "최종 우승자 : %s";

	public static void printReadCarNamesMessage() {
		System.out.println(READ_CAR_NAMES_MASSAGE);
	}

	public static void printReadRacingRoundMessage() {
		System.out.println(READ_RACING_ROUND_MASSAGE);
	}

	public static void printStartRoundMessage() {
		System.out.println(START_ROUND_MASSAGE);
	}

	public static void printCarState(String name, int position) {
		StringBuilder bars = new StringBuilder();
		for (int i = 0; i < position; i++) {
			bars.append("-");
		}
		System.out.printf(CAR_STATE, name, bars.toString());
	}

	public static void printWinners(List<Car> winners) {
		String joinCommaWinners = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));
		System.out.printf(WINNERS_FORM, joinCommaWinners);
	}

	public static void printErrorMessage(Exception e) {
		System.out.println(e.getMessage());
	}
}
