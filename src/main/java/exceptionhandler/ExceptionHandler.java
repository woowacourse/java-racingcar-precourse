/*
 * 클래스명 : ExceptionHandler
 * 
 * version : 0.1
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
	private static final int MAX_CAR_NAME = 5;
	private List<String> usedCarNames = new ArrayList<>();
	private String[] carNames;
	
	public ExceptionHandler(String carNamesWithComma) {
		carNames = carNamesWithComma.split(",");
	}

	public boolean isDuplicated() {
		
		for (String carName : carNames) {
			if (usedCarNames.contains(carName)) {
				System.out.println(DUPLICATED_NAME);
				return true;
			}
			usedCarNames.add(carName);
		}
		return false;
	}

	public boolean checkNameRange() {
		boolean status = false;
		for (String carName : carNames) {
			if (carName.length() > MAX_CAR_NAME) {
				status = true;
				System.out.println(OVER_5_WORDS);
			}
		}
		return status;
	}
}