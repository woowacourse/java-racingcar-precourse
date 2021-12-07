package racingcar.game;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.Constant.*;
import static racingcar.constant.Message.*;

import java.util.Arrays;

public class Input {
	public String[] inputNames() {
		long check = 1;
		String[] names;
		do {
			System.out.println(INPUT_CAR_NAMES);
			names = readLine().split(SPLITOR);
			check = checkLen(names);
			if (check > 0) {
				System.out.println(ERROR_NAME_LENGTH);
			}
		} while (check > 0);
		return names;
	}

	private long checkLen(String[] names) {
		return Arrays.stream(names)
			.filter(name -> name.length() > MAX_NAME_LENGTH)
			.count();
	}

	public int inputNum() {
		System.out.println(INPUT_TRY_NUMBER);
		int num = 0;
		int flg = 0;

		while (flg == 0) {
			try {
				num = Integer.parseInt(readLine());
				flg = 1;
			} catch (Exception e) {
				System.out.println(ERROR_TRY_NUMBER);
			}
		}
		return num;
	}
}
