package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Message;

public class InputView {

	private static final int CAR_NAME_LENGTH_MIN = 1;
	private static final int CAR_NAME_LENGTH_MAX = 5;
	private static final char STRING_GAME_COUNT_MIN = '0';
	private static final char STRING_GAME_COUNT_MAX = '9';
	private static final int ZERO_GAME_COUNT = 0;

	public static List<String> carNamesInput() {
		List<String> carsNameList = new ArrayList<String>();

		do {
			System.out.println(Message.ASK_CAR_NAMES);
			String carNames = Console.readLine();
			String[] carArray = carNames.split(",");
			carsNameList = Arrays.asList(carArray);
		} while (!checkRightNames(carsNameList));

		return carsNameList;
	}

	public static String gameCountInput() {
		String stringGameCount = "";
		int gameCount = 0;

		do {
			System.out.println(Message.ASK_GAME_COUNT);
			stringGameCount = Console.readLine();
		} while (!checkRightGameCount(stringGameCount));

		return stringGameCount;
	}

	public static boolean checkRightNames(List<String> carsNameList) {
		boolean isRightNames = true;

		try {
			lessMoreNameError(carsNameList);
			containSameNameError(carsNameList);
			whiteSpaceNameError(carsNameList);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightNames = false;
		}
		return isRightNames;
	}

	public static boolean checkRightGameCount(String stringGameCount) {
		boolean isRightNumeric = true;

		try {
			nonNumericGameCountError(stringGameCount);
			zeroGameCountError(stringGameCount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightNumeric = false;
		}
		return isRightNumeric;
	}

	public static void lessMoreNameError(List<String> carsList) {
		for (int i = 0; i < carsList.size(); i++) {
			if (carsList.get(i).length() < CAR_NAME_LENGTH_MIN || carsList.get(i).length() > CAR_NAME_LENGTH_MAX) {
				throw new IllegalArgumentException(Message.LESS_MORE_NAME_ERROR);
			}
		}
	}

	public static void containSameNameError(List<String> carsList) {
		Set<String> carsSet = new HashSet<String>();
		for (int i = 0; i < carsList.size(); i++) {
			carsSet.add(carsList.get(i));
		}

		if (carsSet.size() < carsList.size()) {
			throw new IllegalArgumentException(Message.CONTAIN_SAME_NAME_ERROR);
		}
	}

	public static void whiteSpaceNameError(List<String> carsList) {
		for (int i = 0; i < carsList.size(); i++) {
			if (carsList.get(i).trim().isEmpty()) {
				throw new IllegalArgumentException(Message.WHITE_SPACE_NAME_ERROR);
			}
		}
	}

	public static void nonNumericGameCountError(String stringGameCount) {
		for (int i = 0; i < stringGameCount.length(); i++) {
			if (stringGameCount.charAt(i) < STRING_GAME_COUNT_MIN || STRING_GAME_COUNT_MAX < stringGameCount.charAt(
					i)) {
				throw new IllegalArgumentException(Message.NON_NUMERIC_GAME_COUNT_ERROR);
			}
		}
	}

	public static void zeroGameCountError(String stringGameCount) {
		if (stringGameCount.equals(ZERO_GAME_COUNT)) {
			throw new IllegalArgumentException(Message.ZERO_GAME_COUNT_ERROR);
		}
	}

}
