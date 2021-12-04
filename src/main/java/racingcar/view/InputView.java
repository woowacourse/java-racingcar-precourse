package racingcar.view;

import java.util.List;

import racingcar.util.InputUtil;

public class InputView {
	private static final String NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	private InputView() {
	}

	public static List<String> readCarNames() {
		System.out.println(NAMES_INPUT_MESSAGE);
		return InputUtil.readStringList();
	}

	public static int readTryCount() {
		System.out.println(TRY_COUNT_INPUT_MESSAGE);
		return InputUtil.readInt();
	}
}
