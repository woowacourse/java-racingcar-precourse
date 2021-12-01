package racingcar.view;

public class InputView {
	private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static void startMessage() {
		System.out.println(REQUEST_CAR_NAME);
	}
}
