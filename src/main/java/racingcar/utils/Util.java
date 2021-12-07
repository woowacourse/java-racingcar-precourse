package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

	public static void checkNamesValidation(String inputValue, String delimeter) {
		checkNullOrEmpty(inputValue);
		checkValidFirstValue(inputValue, delimeter);
		checkValidCountOfNames(inputValue, delimeter);
		checkDuplicatesOfNames(inputValue, delimeter);
		checkLengthEveryName(inputValue, delimeter);
	}

	private static void checkNullOrEmpty(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throw new IllegalArgumentException(Message.REQUEST_NULL_OR_EMPTY_MESSAGE);
		}
	}

	private static void checkValidFirstValue(String inputValue, String delimeter) {
		if (inputValue.charAt(Constant.FIRST_INDEX) == delimeter.charAt(Constant.FIRST_INDEX)) {
			throw new IllegalArgumentException(Message.REQUEST_VALID_FIRST_VALUE_MESSAGE);
		}
	}

	private static void checkValidCountOfNames(String inputValue, String delimeter) {
		if (inputValue.split(delimeter).length < Constant.MIN_COUNT) {
			throw new IllegalArgumentException(Message.REQUEST_VALID_COUNT_OF_NAMES_MESSAGE);
		}
	}

	private static void checkDuplicatesOfNames(String inputValue, String delimeter) {
		List<String> splitedInputValue = Arrays.stream(inputValue.split(delimeter))
			.map(String::trim)  // split + 개별 trim()적용 -> list로 모으기
			.collect(Collectors.toList());
		if (splitedInputValue.stream().distinct().count() != splitedInputValue.size()) {
			throw new IllegalArgumentException(Message.REQUEST_DUPLICATES_OF_NAMES_MESSAGE);
		}
	}

	private static void checkLengthEveryName(String inputValue, String delimeter) {
		List<String> splitedInputValue = Arrays.stream(inputValue.split(delimeter))
			.map(String::trim)
			.collect(Collectors.toList());
		if (!isValidName(splitedInputValue)) { // 딜리미터쪼갠후    개별단어, [[입력갯수(길이) 최소 ~ 최대값]] 입력
			throw new IllegalArgumentException(Message.REQUEST_LENGTH_EVERY_NAME_MESSAGE);
		}
	}

	private static boolean isValidName(List<String> splitedInputValue) {
		return splitedInputValue.stream()
			.allMatch(name -> Constant.MIN_LENGTH <= name.length()
				&& name.length() <= Constant.MAX_LENGTH);
	}

	public static void checkCountValidation(String inputValue) {
		checkNullOrEmpty(inputValue);
		checkValidFormatOfCount(inputValue);
		checkValidRangeCount(inputValue);

	}

	private static void checkValidFormatOfCount(String inputValue) {
		if (!(inputValue.chars().allMatch(Character::isDigit))) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_VALID_FORMAT_OF_COUNT);
		}
	}

	private static void checkValidRangeCount(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (Constant.MIN_RANGE > number) {
			throw new IllegalArgumentException(Message.REQUEST_MESSAGE_VALID_RANGE_COUNT);
		}
	}

	public static int getRandomNumber() {
		return Randoms.pickNumberInRange(Constant.MIN_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER);
	}
}
