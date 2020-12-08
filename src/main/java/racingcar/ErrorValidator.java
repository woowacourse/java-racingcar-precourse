package racingcar;

public class ErrorValidator {
    final static String playTimeIntegerError = "[ERROR] 시도 횟수는 숫자여야 한다.";
    final static String playTimeZeroError = "[ERROR] 시도 횟수는 0보다 커야 한다.";
    final static String inputNameError = "[ERROR] 자동차 이름에 공백만 존재하면 안된다.";

    public static void checkCarNameInput(String[] carsList) {
        if (carsList.length == 0) {
            throw new IllegalArgumentException(inputNameError);
        }
        for (int i = 0; i < carsList.length; i++) {
            if (carsList[i] == "" || carsList[i].length() > 5) {
                throw new IllegalArgumentException(inputNameError);
            }
        }
    }

    public static void checkNumeric(String checkString) {
        int checkInt;
        try {
            checkInt = Integer.parseInt(checkString);
        } catch (Exception e) {
            throw new IllegalArgumentException(playTimeIntegerError);
        }
        if (checkInt <= 0) {
            throw new IllegalArgumentException(playTimeZeroError);
        }
    }
}
