/*
 * 클래스명 : ExceptionHandler
 * 
 * version : 0.2
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
	private static final int MAX_CAR_NAME = 5;
	private static final int MIN_TRY_NUM = 1;
	private List<String> usedCarNames = new ArrayList<>();
	private String[] carNames;
	private int tryNum;

	public boolean checkNameRange(String carNamesWithComma) {
		boolean status = false;
		this.carNames = carNamesWithComma.split(",");
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

	public boolean checkTryRange(int numOfTries) {
		tryNum = numOfTries;
		if (tryNum < MIN_TRY_NUM) {
			System.out.println(LESS_THAN_ONE);
			return true;
		}
		return false;
	}

}
