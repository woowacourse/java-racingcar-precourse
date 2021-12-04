package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Util {

	public static int findMax(ArrayList<Integer> integers) {
		return Collections.max(integers);
	}

	public static ArrayList<String> toNameArray(String carsString) {
		return new ArrayList<>(Arrays.asList(carsString.split(Constants.DELIMITER)));
	}
}
