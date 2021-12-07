package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final String INPUT_CAR_NAMES_NOTICE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_ROUND_NUMBER_NOTICE = "시도할 회수는 몇회인가요?";

	public static String getCarNames() {
		System.out.println(INPUT_CAR_NAMES_NOTICE);
		return Console.readLine();
	}

	public static String getRoundNumber() {
		System.out.println(INPUT_ROUND_NUMBER_NOTICE);
		return Console.readLine();
	}
}
