package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class InputView {
	public static final String INPUT_EVERY_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String CAR_SPLIT_REGEX = ",";

	public static void enterEveryCarName() {
		System.out.println(INPUT_EVERY_CAR_NAME_MESSAGE);
		String[] everyCarName = Console.readLine().split(CAR_SPLIT_REGEX);
		for (String s : everyCarName) {
			System.out.println("s = " + s);
		}
	}
}
