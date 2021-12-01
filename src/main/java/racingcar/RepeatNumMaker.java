package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RepeatNumMaker {
	RepeatNumMaker(){
		makeNum();
	}

	private void makeNum(){
		System.out.println("시도할 회수는 몇회인가요?");

		String input = Console.readLine();

		// 검사 : 1.숫자인지 2. 정수인지 3.1보다 큰지

		repeatNum = Integer.parseInt(input);
	}

	private int repeatNum = 0;

	int getRepeatNum(){
		return this.repeatNum;
	}
}