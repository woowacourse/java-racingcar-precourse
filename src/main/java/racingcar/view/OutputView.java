package racingcar.view;

public class OutputView {
	private static final String READ_CAR_NAMES_MASSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static void printReadCarNamesMessage() {
		System.out.println(READ_CAR_NAMES_MASSAGE);
	}
}
