package racingcar.game;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;

public class Input {
	public String[] inputNames() {
		long check = 1;
		String[] names;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			names = readLine().split(",");
			check = checkLen(names);
			if (check > 0) {
				System.out.println("[ERROR] 이름은 5자 이하만 가능합니다");
			}
		} while (check > 0);
		return names;
	}

	private long checkLen(String[] names) {
		return Arrays.stream(names)
			.filter(name -> name.length() > 5)
			.count();
	}

	public int inputNum() {
		System.out.println("시도할 회수는 몇회인가요?");
		int num = 0;
		int flg = 0;

		while (flg == 0) {
			try {
				num = Integer.parseInt(readLine());
				flg = 1;
			} catch (Exception e) {
				System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.\n");
			}
		}
		return num;
	}
}
