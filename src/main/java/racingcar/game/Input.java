package racingcar.game;

import static camp.nextstep.edu.missionutils.Console.*;
import static racingcar.constant.Constant.*;
import static racingcar.constant.Message.*;
import static racingcar.exception.NameException.*;
import static racingcar.exception.NumberException.*;

public class Input {

	public String[] inputNames() {
		boolean check = false;
		String[] names;

		while (true) {
			System.out.println(INPUT_CAR_NAMES);
			names = readLine().split(SPLITTER);
			try {
				checkNameException(names);
				return names;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int inputNum() {
		int num;

		while (true) {
			try {
				System.out.println(INPUT_TRY_NUMBER);
				String input = readLine();
				checkNumberException(input);
				num = Integer.parseInt(input);
				return num;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
