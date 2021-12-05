package racingcar.view;

public class OutputView {
	private static final String READ_CAR_NAMES_MASSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String READ_RACING_ROUND_MASSAGE = "시도할 회수는 몇회인가요?";

	public static void printReadCarNamesMessage() {
		System.out.println(READ_CAR_NAMES_MASSAGE);
	}

	public static void printReadRacingRoundMessage() {
		System.out.println(READ_RACING_ROUND_MASSAGE);
	}

	public static void printErrorMessage(Exception e) {
		System.out.println(e.getMessage());
	}
}
