package service;

public class IntInputValidatorImpl implements IntInputValidator {
    private static final String ERROR_NOT_IN_RANGE = "시도 회수는 자연수여야 합니다.";
    private static final String ERROR_NOT_A_NUMBER = "시도 회수는 숫자여야 합니다.";
    @Override
    public void isInRange(int number) {

        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_IN_RANGE);
        }
    }

    @Override
    public void isNumber(String toCheck) {
        int length = toCheck.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(toCheck.charAt(i))) {
                throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
            }
        }
    }
}
