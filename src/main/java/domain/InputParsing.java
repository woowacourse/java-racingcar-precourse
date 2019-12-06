package domain;

import java.util.ArrayList;
import java.util.List;

public class InputParsing {
	public static List<String> parseArrToList(String[] inputStringArr) {
		List<String> outputList = new ArrayList<String>();
		for (int i = 0; i < inputStringArr.length; i++) {
			checkOverlapping(outputList,inputStringArr[i].trim());
			outputList.add(inputStringArr[i].trim());
		}
		return outputList;
	}
	
	private static void checkOverlapping(List<String> carNames, String carName) {
		if (carNames.contains(carName)) {
			throw new IllegalArgumentException("중복되지 않은 이름들을 입력해주세요");
		}
	}
	
	public static int parseStringToInt(String inputString) {
		try {
			return Integer.parseInt(inputString.trim());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("숫자를 입력해주세요");
		}
	}
}
