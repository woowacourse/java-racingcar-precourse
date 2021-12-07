package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

	public static int getMax(ArrayList<Integer> integers) {
		return Collections.max(integers);
	}

	public static ArrayList<String> toArrayList(String carsString) {
		return new ArrayList<>(Arrays.asList(carsString.split(Constants.DELIMITER)));
	}

	public static int getRandomNum() {
		return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
	}

	public static String dashRepeat(int num) {
		StringBuilder dashes = new StringBuilder();
		IntStream.range(0, num).forEach(i -> dashes.append(Constants.DASH));
		return dashes.toString();
	}
}
