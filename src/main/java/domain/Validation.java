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
		private static final int MIN_NUMBER_OF_TRY = 1;
		private static final int MAX_NUMBER_OF_TRY = 100;
		private static final int MIN_LENGTH_OF_NAME = 1;
		private static final int MAX_LENGTH_OF_NAME = 5;
		
		/** 사용자로부터 입력 받은 차 이름의 개수가 하나인지 확인하는 함수에서 사용되는 상수 */
		private static final int ONLY_ONE_CAR = 1;
	
		private static final String NAME_LENGTH_ERROR = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";
		private static final String NUM_OF_NAME_ERROR = "두 대 이상의 자동차 이름이 필요합니다.";
		private static final String NUM_OF_TRY_ERROR = MIN_NUMBER_OF_TRY + " 이상 " 
				+ MAX_NUMBER_OF_TRY + " 이하의 자연수만 가능합니다.";

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

		/**
		 * 사용자로부터 입력받은 자동차의 이름이 하나인지 아닌지 확인합니다.
		 * @param nameList - 사용자로부터 입력받은 자동차 이름들의 리스
		 * @return false - 입력받은 이름이 하나인 경우
		 * 		   true - 입력받은 이름이 두 개 이상인 경우
		 */
		private static boolean isValidNumOfCarName(String[] nameList) {
				if (nameList.length == ONLY_ONE_CAR) {
						System.out.println(NUM_OF_NAME_ERROR);
						return false;
				}
				return true;
		}

		public static boolean isValidTryNum(String strOfTry) {
				return (isNumber(strOfTry) && isValidRangeOfTryNum(strOfTry) ? true : false);
		}

		private static boolean isNumber(String strOfTry) {
				try {
						Integer.parseInt(strOfTry);
						return true;
				} catch (NumberFormatException e) {
						System.out.println(NUM_OF_TRY_ERROR);
						return false;
				}
		}

		private static boolean isValidRangeOfTryNum(String strOfTry) {

		}
}