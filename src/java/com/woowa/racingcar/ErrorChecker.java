/*
 * Class: ErrorChecker.java
 * Version: 1.0
 * Date: 2019-04-02
 * Author: Kibaek Yoo
 */

package com.woowa.racingcar;

public class ErrorChecker {

    public static final int CAR_NAME_MAX_LENGTH = 5;    // 자동차이름 최대 길이
    public static final int CAR_NAME_MIN_LENGTH = 1;    // 자동차이름 최소 길이
    private static final String COMMENT_WHEN_CAR_NAME_LENGTH_ERROR = "자동차 이름은 " + CAR_NAME_MIN_LENGTH + "이상"
            + CAR_NAME_MAX_LENGTH + "이하 이어야 합니다.";

    /**
     * (,)로 구분된 자동차이름 String의 조건 검사 함수
     *
     * @param carName 체크할 String
     * @return 해당 String 사용가능한지 여부
     */
    public static boolean checkCarStringHaveError(String carName) {
        String[] carNames = carName.split(",");

        for (int i = 0; i < carNames.length; i++) {
            // 자동차 이름의 길이가 범위를 벗어나면 에러!
            if (carNames[i].length() > CAR_NAME_MAX_LENGTH ||
                    carNames[i].length() < CAR_NAME_MIN_LENGTH) {
                System.out.println(COMMENT_WHEN_CAR_NAME_LENGTH_ERROR);
                return true;
            }
        }
        return false;
    }

    public static boolean checkRunCountStringHasError(String userInput) {

        try {
            int parsedInt = Integer.parseInt(userInput);
            if (parsedInt <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
