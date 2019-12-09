package seonggyu.input;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputParser {
	public static List<String> parseStringArrToList(String[] inputStringArr) {
		List<String> parsedList = new ArrayList<String>(Arrays.asList(inputStringArr));
		return trimedStringList(parsedList);
	}
	
	private static List<String> trimedStringList(List<String> inputList){
		return inputList.stream()
			.map(String::trim)
			.collect(Collectors.toList());
	}
	
	public static int parseStringToInt(String inputString) {
		try {
			return Integer.parseInt(inputString.trim());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("숫자를 입력해주세요");
		}
	}
}
