package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator;

/*
* 사용자로부터 입력받기
* */
public class UserView {

	public static String[] setCarNamesInput() {
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

		while(true) {
			try {
				String[] carNames = Console.readLine().split(",");
				Validator.validateCarNames(carNames);
				return carNames;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int setRoundInput() {
		System.out.println("시도할 횟수는 몇회인가요?");

		while(true) {
			try {
				String trialNum = Console.readLine();
				Validator.validateRoundNum(trialNum);
				return Integer.parseInt(trialNum);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
