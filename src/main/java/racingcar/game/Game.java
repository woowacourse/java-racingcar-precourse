package racingcar.game;

import static camp.nextstep.edu.missionutils.Console.*;

public class Game {
	public int num;

	public Game() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] names = readLine().split(",");

		System.out.println("시도할 회수는 몇회인가요?");
		num = inputNum();
	}

	private int inputNum() {
		int num;

		try {
			num = Integer.parseInt(readLine());
		} catch (Exception e) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.\n");
			num = inputNum();
		}
		return num;
	}

}
