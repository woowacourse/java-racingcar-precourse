package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	public static List<String> strToList(String str) {
		String[] strSplited = str.split(",");
		List<String> list;
		list = new ArrayList<>(Arrays.asList(strSplited));

		return list;
	}
}
