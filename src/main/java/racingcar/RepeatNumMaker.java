package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RepeatNumMaker {
	RepeatNumMaker() {
		makeNum();
	}

	private void makeNum() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = Console.readLine();
		new InputValidator().isIntAndGTE1(input);
		repeatNum = Integer.parseInt(input);
	}

	private int repeatNum = 0;

	int getRepeatNum() {
		return this.repeatNum;
	}
}