package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {

	public static final String REQUEST_NULL_OR_EMPTY_MESSAGE = "빈칸 입력은 허용하지 않는다.";
	public static final String REQUEST_VALID_FIRST_VALUE_MESSAGE = "정상적인 이름을 입력하세요.";
	public static final String REQUEST_VALID_COUNT_OF_NAMES_MESSAGE = "최소 2개 이상 입력하세요.";
	public static final String REQUEST_DUPLICATES_OF_NAMES_MESSAGE = "중복값을 입력할 수 없습니다.";
	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 5;
	public static final String REQUEST_LENGTH_EVERY_NAME_MESSAGE =
		"각 Name은(는) " + MIN_LENGTH + " ~ " + MAX_LENGTH + "자 사이로 입력해주세요.";
	public static final String REQUEST_MESSAGE_VALID_FORMAT_OF_COUNT = "시도 횟수는 숫자여야 한다.";
	public static final int MIN_RANGE = 1;
	public static final String REQUEST_MESSAGE_VALID_RANGE_COUNT = "정상 범위(" + MIN_RANGE + "이상)가 아닙니다";
	public static final int MIN_RANDOM_NUMBER = 0;
	public static final int MAX_RANDOM_NUMBER = 9;
	public static final int FIRST_INDEX = 0;
	public static final int MIN_COUNT = 2;

	public static void checkNamesValidation(String inputValue, String delimeter) {
		checkNullOrEmpty(inputValue);
		checkValidFirstValue(inputValue, delimeter);
		checkValidCountOfNames(inputValue, delimeter);
		checkDuplicatesOfNames(inputValue, delimeter);
		checkLengthEveryName(inputValue, delimeter);
	}

	private static void checkNullOrEmpty(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()){
			throw new IllegalArgumentException(REQUEST_NULL_OR_EMPTY_MESSAGE);
		}
	}

	private static void checkValidFirstValue(String inputValue, String delimeter) {
		if (inputValue.charAt(FIRST_INDEX) == delimeter.charAt(FIRST_INDEX)) {
			throw new IllegalArgumentException(REQUEST_VALID_FIRST_VALUE_MESSAGE);
		}
	}

	private static void checkValidCountOfNames(String inputValue, String delimeter) {
		if (inputValue.split(delimeter).length < MIN_COUNT) {
			throw new IllegalArgumentException(REQUEST_VALID_COUNT_OF_NAMES_MESSAGE);
		}
	}

	private static void checkDuplicatesOfNames(String inputValue, String delimeter) {
		List<String> splitedInputValue = Arrays.stream(inputValue.split(delimeter))
			.map(String::trim)  // split + 개별 trim()적용 -> list로 모으기
			.collect(Collectors.toList());
		if (splitedInputValue.stream().distinct().count() != splitedInputValue.size()) {
			throw new IllegalArgumentException(REQUEST_DUPLICATES_OF_NAMES_MESSAGE);
		}
	}

	private static void checkLengthEveryName(String inputValue, String delimeter) {
		List<String> splitedInputValue = Arrays.stream(inputValue.split(delimeter))
			.map(String::trim)
			.collect(Collectors.toList());
		if (!isValidName(splitedInputValue)) { // 딜리미터쪼갠후    개별단어, [[입력갯수(길이) 최소 ~ 최대값]] 입력
			throw new IllegalArgumentException(REQUEST_LENGTH_EVERY_NAME_MESSAGE);
		}
	}

	private static boolean isValidName(List<String> splitedInputValue) {
		return splitedInputValue.stream()
			.allMatch(name -> MIN_LENGTH <= name.length()
				&& name.length() <= MAX_LENGTH);
	}

	public static void checkCountValidation(String inputValue) {
		checkNullOrEmpty(inputValue);
		checkValidFormatOfCount(inputValue);
		checkValidRangeCount(inputValue);

	}

	private static void checkValidFormatOfCount(String inputValue) {
		if (!(inputValue.chars().allMatch(Character::isDigit))) {
			throw new IllegalArgumentException(REQUEST_MESSAGE_VALID_FORMAT_OF_COUNT);
		}
	}

	private static void checkValidRangeCount(String inputValue) {
		int number = Integer.parseInt(inputValue);
		if (MIN_RANGE > number) {
			throw new IllegalArgumentException(REQUEST_MESSAGE_VALID_RANGE_COUNT);
		}
	}

	public static int getRandomNumber() {
		return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
	}
}
