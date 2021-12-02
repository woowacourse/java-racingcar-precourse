package racingcar.view;

public class OutputView {

	private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.";
	private static final String CAR_NAMES_CONDITION = "(이름은 쉼표(,) 기준으로 구분)";

	private OutputView() {
	}

	public static void askCarNames() {
		System.out.println(ASK_CAR_NAMES + CAR_NAMES_CONDITION);
	}

	public static void printError(IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}
}
