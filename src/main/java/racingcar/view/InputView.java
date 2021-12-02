package racingcar.view;

import java.util.Arrays;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static final int NAME_SIZE = 5;

	public static String carInput() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return Console.readLine();
	}

	public static String roundInput() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Console.readLine();
	}

	public static int getRoundCount() {
		int roundCount;
		do {
			roundCount = inputToInt(roundInput());
		} while (roundCount == -1);
		return roundCount;
	}

	public static String[] getNames() {
		String[] names;
		do {
			names = inputToStringArray(carInput());
		} while (names.length == 0);
		return names;
	}

	public static int inputToInt(String roundNum) {
		if (isInt(roundNum)) {
			return Integer.parseInt(roundNum);
		}
		System.out.println("[ERROR] 1글자 이상의 정수 형식으로 입력해야 한다.");
		return -1;
	}

	public static String[] inputToStringArray(String carsString) {
		String[] carStringArray = carsString.split(",");
		if (isRightName(carsString) && isNotDuplicate(carStringArray) && isRightNameSize(carStringArray)) {
			return carStringArray;
		}
		System.out.println("[ERROR] 잘못된 값이 입력되었습니다.");
		return new String[0];
	}

	public static boolean isRightNameSize(String[] strings) {
		return Arrays.stream(strings)
			.allMatch(s -> !s.isEmpty() && s.length() <= NAME_SIZE);
	}

	public static boolean isRightName(String str) {
		return isNameOrRest(str) && !str.isEmpty() && str.charAt(str.length() - 1) != ',';
	}

	public static boolean isNotDuplicate(String[] strings) {
		return strings.length == Arrays.stream(strings).distinct().count();
	}

	public static boolean isNameOrRest(String str) {
		String pattern = "^[가-힣\\w][가-힣\\w,]*$"; //한글, 영어, 숫자, 쉼표만 됨
		return Pattern.matches(pattern, str);
	}

	public static boolean isInt(String str) {
		String pattern = "^[1-9][0-9]*$"; //숫자만 됨
		return Pattern.matches(pattern, str);
	}

}
