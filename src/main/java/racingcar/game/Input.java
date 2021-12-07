package racingcar.game;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.Constant.*;
import static racingcar.constant.Message.*;

import java.util.Arrays;

public class Input {
	public String[] inputNames() {
		boolean check = false;
		String[] names;
		do {
			System.out.println(INPUT_CAR_NAMES);
			names = readLine().split(SPLITOR);
			check = checkMaxLen(names) && checkMinLen(names);
			if (checkEmpty(names)) {
				check = false;
			}
		} while (!check);
		return names;
	}

	private boolean checkEmpty(String[] names) {
		if (Arrays.stream(names).count() == 0) {
			System.out.println(ERROR_NAME_MIN_LENGTH);
			return true;
		}
		return false;
	}

	//이름의 길이 확인한다
	private boolean checkMaxLen(String[] names) {
		long check = Arrays.stream(names)
			.filter(name -> name.length() > MAX_NAME_LENGTH)
			.count();
		if (check > 0) {
			System.out.println(ERROR_NAME_MAX_LENGTH);
			return false;
		}
		return true;
	}

	private boolean checkMinLen(String[] names) {
		long check = Arrays.stream(names)
			.filter(name -> name.length() < 1)
			.count();
		if (check > 0) {
			System.out.println(ERROR_NAME_MIN_LENGTH);
			return false;
		}
		return true;
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
