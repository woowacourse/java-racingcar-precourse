package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final String INPUT_NOTICE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public String getCarNames() {
		System.out.println(INPUT_NOTICE);
		return Console.readLine();
	}
}
