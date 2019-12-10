/*
 * 클래스명 : ExceptionHandler
 * 
 * version : 0.4
 * 
 * 날짜 : 2019.12.08
 * 
 * 작성자 : ParkDooWon
 */
package exceptionhandler;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandler {
	private static final String OVER_5_WORDS = "자동차 이름이 5자를 초과했습니다. 5자 이하로 다시 입력해주세요.";
	private static final String DUPLICATED_NAME = "자동차 이름이 중복되었습니다. 중복되는 이름이 없도록 다시 입력해주세요.";
	private static final String LESS_THAN_ONE = "시도할 회수가 1보다 작습니다. 1회 이상의 회수를 다시 입력해주세요.";
	private static final String NOT_NUMBER = "숫자로만 이루어진 회수를 정수로 입력해주세요.";
	private static final String NO_CAR_NAME = "1대 이상의 자동차 이름을 입력해주세요.";
	private static final int MAX_CAR_NAME = 5;
	private static final int MIN_TRY_NUM = 1;

	private List<String> usedCarNames = new ArrayList<>();
	private String[] carNames;
	private int tryNum;

	public boolean checkNameRange(String carNamesDividedByComma) {
		boolean status = false;
		this.carNames = carNamesDividedByComma.split(",");
		for (String carName : carNames) {
			if (carName.length() > MAX_CAR_NAME) {
				status = true;
				System.out.println(OVER_5_WORDS);
			}
		}
		return status;
	}

	public boolean isDuplicated() {
		usedCarNames.clear();
		for (String carName : carNames) {
			if (usedCarNames.contains(carName)) {
				System.out.println(DUPLICATED_NAME);
				return true;
			}
			usedCarNames.add(carName);
		}
		return false;
	}

	public boolean isNothing() {
		if (carNames == null || carNames.length == 0) {
			System.out.println(NO_CAR_NAME);
			return true;
		}
		return false;
	}

	public boolean isNumber(String numOfTries) {
		/* 음수를 입력받을 때, '-' 부분이 문자로 인식되어 음수가 숫자임에도 숫자가 아니라고 출력되는 것을 방지 */
		String[] stringTryNum = numOfTries.split("");
		for (int i = 0; i < stringTryNum.length; i++) {
			if (stringTryNum[0].equals("-") && stringTryNum.length > 1) {
				continue;
			} else if (stringTryNum[i].charAt(0) - '0' < 0 || stringTryNum[i].charAt(0) - '0' > 9) {
				System.out.println(NOT_NUMBER);
				return true;
			}
		}
		tryNum = Integer.valueOf(numOfTries);
		return false;
	}

	public boolean checkTryRange(String numOfTries) {
		if (tryNum < MIN_TRY_NUM) {
			System.out.println(LESS_THAN_ONE);
			return true;
		}
		return false;
	}

}
