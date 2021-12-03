package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.constants.Constants;

public class Converter {
	public List<String> convertStringToList(String inputString) {
		String [] splitedArray = inputString.split(Constants.CUT_OFF_POINT);
		return Arrays.asList(splitedArray);
	}

	public int convertStringToInt(String numberString) {
		return Integer.valueOf(numberString);
	}
}
