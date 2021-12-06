package racingcar.view;

import static racingcar.resource.MessageResoruce.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public String inputNames() {
		System.out.println(INPUT_NAMES_MESSAGE);
		return Console.readLine();
	}
}
