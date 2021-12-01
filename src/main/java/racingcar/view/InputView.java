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

	public static int inputToInt(String roundNum) throws IllegalArgumentException {
		try {
			if (!isInt(roundNum)) {
				throw new IllegalArgumentException("[ERROR] 1글자 이상의 정수 형식으로 입력해야 한다.");
			}
			return Integer.parseInt(roundNum);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputToInt(InputView.roundInput());
		}
	}

	public static String[] inputToStringArray(String carsString) throws IllegalArgumentException {
		try {
			if (!isNameOrRest(carsString) || carsString.isEmpty() || carsString.charAt(carsString.length()-1) == ',') {
				throw new IllegalArgumentException("[ERROR] 1글자 이상의 이름을 입력해야 한다.");
			}
			String[] carsStringArray = carsString.split(",");
			if (!isNotDuplicate(carsStringArray)) {
				throw new IllegalArgumentException("[ERROR] 중복되는 이름이 없어야 한다.");
			}
			for (String carString : carsStringArray) {
				if (carString.isEmpty() || carString.length() > NAME_SIZE) {
					throw new IllegalArgumentException("[ERROR] 이름 형식에 맞게 써야 한다.");
				}
			}
			return carsStringArray;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputToStringArray(InputView.carInput());
		}
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
