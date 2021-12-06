package racingcar.view;

import static racingcar.view.OutputView.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String scanCarNames() {
		printfMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return Console.readLine();
	}

	public static String scanTryNumber() {
		printfMessage("시도할 회수는 몇회인가요?");
		return Console.readLine();
	}
}
