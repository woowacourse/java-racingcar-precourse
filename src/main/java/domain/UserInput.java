/*
 *  클래스 이름 : UserInput.java
 *
 *  버전 정보 :
 *
 *  날짜 : 2019-03-29
 *
 *  저작권 : 이예지
 */

package domain;

import java.util.*;

public class UserInput {

	public String[] getRacingCarName() {
		Scanner scanner = new Scanner(System.in);
		String[] carNameList;
		boolean result;

		do {
			System.out.println("경주할 자동차이름을 입력하세요.");
			carNameList = scanner.nextLine().split(",");
			result = checkCarNameList(carNameList);
		}
		while (result != true);

		scanner.close();

		return carNameList;
	}

	public boolean checkCarNameList(String[] carNameList) {

		for (int i = 0; i < carNameList.length; ++i) {
			if (carNameList[i].length() > 5) {
				return false;
			}
		}

		return true;
	}
}
