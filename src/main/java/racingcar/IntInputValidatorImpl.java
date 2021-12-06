package racingcar;

public class IntInputValidatorImpl implements IntInputValidator {
    @Override
    public void isInRange(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("시도 회수는 자연수여야 합니다.");
        }
    }

    @Override
    public void isNumber(String toCheck) {
        int length = toCheck.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(toCheck.charAt(i))) {
                throw new IllegalArgumentException("시도 회수는 숫자여야 합니다.");
            }
        }
    }
}
