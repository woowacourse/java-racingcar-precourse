/*
 *  클래스 이름 : UserInput.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-03-29
 *
 *  저작권 : 이예지
 */

package domain;

import java.util.*;

public class UserInput {
	static final String DEMAND_RACING_CAR_NAME = "경주할 자동차이름을 입력하세요.";
	static final String DEMAND_CAR_GAME_TRY_COUNT = "시도할 회수는 몇 회인가요?";
	static final String DEMAND_RULE_FOR_CAR_NAME = "자동차의 이름은 5자 이하만 가능합니다.";
	static final String DEMAND_RULE_FOR_TRY_COUNT = "올바르지 않은 입력입니다.";
	static final int MAX_CAR_NAME_LENGTH = 5;

	public String[] getRacingCarName() {
		Scanner scanner = new Scanner(System.in);
		String[] carNameList;
		boolean result;

		do {
			System.out.println(DEMAND_RACING_CAR_NAME);
			carNameList = scanner.nextLine().split(",");
			result = checkCarNameList(carNameList);
		}
		while (result != true);

		return carNameList;
	}

	public boolean checkCarNameList(String[] carNameList) {
		for (int i = 0; i < carNameList.length; ++i) {
			if (carNameList[i].length() > MAX_CAR_NAME_LENGTH) {
				System.out.println(DEMAND_RULE_FOR_CAR_NAME);
				return false;
			}
		}

		return true;
	}

	public int getTryCount() {
		Scanner scanner = new Scanner(System.in);
		String count;
		boolean result;

		do {
			System.out.println(DEMAND_CAR_GAME_TRY_COUNT);
			count = scanner.nextLine();
			result = checkTryCount(count);
		}
		while (result != true);

		return Integer.parseInt(count);
	}

	public boolean checkTryCount(String count) {
		if (!count.matches("[1-9]||[1-9][0-9]+")) {
			System.out.println(DEMAND_RULE_FOR_TRY_COUNT);
			return false;
		}
		return true;
	}

}
