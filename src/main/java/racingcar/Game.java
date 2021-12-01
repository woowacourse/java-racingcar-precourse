package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
	public static String generateUserInput() {
		String userInput;
		userInput = readLine();

		return userInput;
	}

	public static List<String> strToList(String str) {
		String[] strSplited = str.split(",");
		List<String> list;
		list = new ArrayList<>(Arrays.asList(strSplited));

		return list;
	}

	public static Cars generateCars() {
		List<String> userInput = strToList(generateUserInput());
		ValidationUtils.validCarList(userInput);
		Cars carList;
		carList = new Cars(userInput);
		return carList;
	}
}
