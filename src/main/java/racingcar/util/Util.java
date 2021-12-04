package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Util {

	static public int getRandomNumber(int start, int end) {
		return Randoms.pickNumberInRange(start, end);
	}

	static public String[] splitCars(String cars) {
		return cars.split(",");
	}
}
