package racingcar;

public class InputValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String ERROR_PREFIX_MESSAGE = "[ERROR] ";

    public void validateCarNameListInput(String[] names) {
        for (String name: names) {
            validateLength(name);
        }
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX_MESSAGE + "자동차의 이름은 " + CAR_NAME_MAX_LENGTH + "자 이하여야 한다.");
        }
    }
}