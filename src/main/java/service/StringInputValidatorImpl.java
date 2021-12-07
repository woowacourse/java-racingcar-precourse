package service;

public class StringInputValidatorImpl implements StringInputValidator {
    private final static String ERROR_NAME_LENGTH = "자동차 이름은 5자 이하여야 합니다.";
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Override
    public void checkLength(String string) {
        if (string.length() > 5) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " " + string + " - " + ERROR_NAME_LENGTH);
        }
    }
}
