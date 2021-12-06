package racingcar;

public class StringInputValidatorImpl implements StringInputValidator {
    @Override
    public void checkLength(String string) {
        if (string.length() > 5) {
            throw new IllegalArgumentException(string + " - 자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
