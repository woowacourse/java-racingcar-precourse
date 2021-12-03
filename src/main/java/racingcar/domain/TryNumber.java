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

    private void tryNumberValidation(String tryNumber) {
        isDigitString(tryNumber);
        isBlank(tryNumber);
    }

    private void isDigitString(String tryNumber) throws IllegalArgumentException {
        for (int i = 0; i < tryNumber.length(); i++) {
            isDigitChar(tryNumber.charAt(i));
        }
    }

    private void isDigitChar(char tryNum) throws IllegalArgumentException {
        if (!Character.isDigit(tryNum)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NOT_DIGIT_ERROR.print());
        }
    }

    private static void isBlank(String tryNumber) throws IllegalArgumentException {
        if (tryNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NULL_ERROR.print());
        }
    }
}
