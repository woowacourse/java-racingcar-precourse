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
		public static boolean isValidCarName(String[] nameList) {
				return isValidCarNameLength(nameList) && isValidNumOfCarName(nameList);
		}

		private static boolean isValidCarNameLength(String[] nameList) {

		}

		private static boolean isValidNumOfCarName(String[] nameList) {

		}
}