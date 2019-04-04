/*
 * @(#)InputError.java
 * v2.0
 * 2019/04/03
 */

package com.codemcd.racingcar;

/**
 * 입력 오류를 처리하기 위한 클래스
 *
 * @author 박성범
 * @version v2.0
 */
public class InputError {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private static boolean isOverlapComma(String str) {
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == ',' && str.charAt(i + 1) == ',') {
                return true;
            }
        }
        return false;
    }

    public static String removeFirstAndLastComma(String str) {

        int strSize = str.length();
        String result = str;
        if (str.startsWith(",")) {
            result = result.substring(1, strSize);
        }
        if (str.endsWith(",")) {
            result = result.substring(0, strSize - 1);
        }
        return result;
    }

    private static boolean isExceedMaxSize(String[] input) {
        for (int i = 0; i < input.length; ++i) {
            if (input[i].length() > MAX_CAR_NAME_LENGTH) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInputCarNameFormat(String input) {

        String[] splitedInput = input.split(",");
        if (isOverlapComma(input)) {
            System.out.println("<오류>: 잘못된 형식입니다. 쉼표는 하나만 사용하세요.");
            return false;
        }
        if (isExceedMaxSize(splitedInput)) {
            System.out.println("<오류>: 자동차 이름이 5글자를 초과하였습니다.");
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
