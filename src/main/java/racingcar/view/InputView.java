package racingcar.view;

import static racingcar.resource.MessageResoruce.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private InputView() {}

	public static String inputNames() {
		System.out.println(INPUT_NAMES_MESSAGE);
		return Console.readLine();
	}

	public static String inputRound() {
		System.out.println(INPUT_ROUND_MESSAGE);
		return Console.readLine();
	}
}
