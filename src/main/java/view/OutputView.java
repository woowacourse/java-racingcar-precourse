package view;

public class OutputView {
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static void printErrorMessage(String errorMessage) {
		System.out.println("[ERROR] " + errorMessage);
	}

	public static void printInputCarNames() {
		System.out.println(INPUT_CAR_NAMES_MESSAGE);
	}
}
