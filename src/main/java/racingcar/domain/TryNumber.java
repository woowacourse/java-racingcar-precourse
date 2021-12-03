package racingcar.domain;

import racingcar.constant.ErrorMessage;

public class TryNumber {
    private String tryNumber;

    public String getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(String tryNumber) throws IllegalArgumentException {
        tryNumberValidation(tryNumber);
        this.tryNumber = tryNumber;
    }

    public void tryNumberValidation(String tryNumber) {
        isDigitString(tryNumber);
        isBlank(tryNumber);
    }

    public void isDigitString(String tryNumber) throws IllegalArgumentException {
        for (int i = 0; i < tryNumber.length(); i++) {
            isDigitChar(tryNumber.charAt(i));
        }
    }

    public void isDigitChar(char tryNum) throws IllegalArgumentException {
        if (!Character.isDigit(tryNum)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NOT_DIGIT_ERROR.print());
        }
    }

    public static void isBlank(String tryNumber) throws IllegalArgumentException {
        if (tryNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NULL_ERROR.print());
        }
    }
}
