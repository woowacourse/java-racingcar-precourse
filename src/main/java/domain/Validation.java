/*
 * @(#)Validation.java		2019/4/4
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Validation 클래스는 입력받은 값 혹은 랜덤한 숫자가 조건에 맞는지 확인하는 기능을 합니다.
 * 
 * @version			1.00 2019년 4월 4일
 * @author 			한준모
 */

package domain;

public class Validation {
		private static final int MIN_LENGTH_OF_NAME = 1;
		private static final int MAX_LENGTH_OF_NAME = 5;
		
		private static final String NAME_LENGTH_ERROR = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";

		public static boolean isValidCarName(String[] nameList) {
				return isValidCarNameLength(nameList) && isValidNumOfCarName(nameList);
		}

		private static boolean isValidCarNameLength(String[] nameList) {
				for (String name : nameList) {
						name = name.trim();
						if (name.length() < MIN_LENGTH_OF_NAME 
								|| name.length() > MAX_LENGTH_OF_NAME) {
							System.out.println(NAME_LENGTH_ERROR);
							return false;
						}
				}
				return true;
		}

		private static boolean isValidNumOfCarName(String[] nameList) {

		}
}