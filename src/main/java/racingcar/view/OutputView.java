package racingcar.view;

public class OutputView {

	public static final String INPUT_NAMES_INSTRUCTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static void printInputNamesInstruction() {
		System.out.println(INPUT_NAMES_INSTRUCTION);
	}

	public static void printError(String errorMessage) {
		System.out.println("[ERROR] " + errorMessage);
	}
}
