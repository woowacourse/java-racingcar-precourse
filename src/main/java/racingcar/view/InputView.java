package racingcar.view;

import static racingcar.view.OutputView.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.type.TextType;

public class InputView {

	public static String scanCarNames() {
		printfMessage(TextType.CAR_NAME_REQUEST.getText());
		return Console.readLine();
	}

	public static String scanTryNumber() {
		printfMessage(TextType.TRY_NUMBER_REQUEST.getText());
		return Console.readLine();
	}
}
