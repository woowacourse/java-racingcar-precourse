package seonggyu.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParsing {
	public static List<String> parseStringArrToList(String[] inputStringArr) {
		List<String> outputList = new ArrayList<String>(Arrays.asList(inputStringArr));
		return outputList;
	}
	
	public static int parseStringToInt(String inputString) {
		try {
			return Integer.parseInt(inputString.trim());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("숫자를 입력해주세요");
		}
	}
}
