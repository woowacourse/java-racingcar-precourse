package racingcar;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자와 소통(질문하고 입력받기)하는 역할을 수행하는 Class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Computer {
	public static String[] askCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();
		return carNames.split(",");
	}
}
