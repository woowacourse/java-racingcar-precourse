package racingcar;

public class InputValidator {
    private static final int MAX_NAME_SIZE = 5;
    private static final int MIN_NAME_SIZE = 1;
    private static final String DIGIT_MATCH_PATTERN = "^[0-9]*$";
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] Car name은 1글자 이상, 5글자 이하여야합니다.";
    private static final String TRY_COUNT_PATTERN_EXCEPTION_MESSAGE = "[ERROR] 시도 회수는 숫자여야만 합니다.";


    public void validateCarNamesInput(String[] names) {
        for (String name : names) {
            if (!isValidNameLength(name))
                throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private boolean isValidNameLength(String name) {
        return name.length() <= MAX_NAME_SIZE && name.length() >= MIN_NAME_SIZE;
    }

    public void validateTryCount(String tryCount) {
        if (!tryCount.matches(DIGIT_MATCH_PATTERN))
            throw new IllegalArgumentException(TRY_COUNT_PATTERN_EXCEPTION_MESSAGE);
    }
}
