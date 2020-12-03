package racingcar;

public class ErrorMessage {
    private static final String ERROR_PREFIX = "[Error] ";
    public static final String SHOULD_BE_NOT_EMPTY_OR_COMMA_NAME =
        ERROR_PREFIX + "이름이 공백이거나 콤마(,)이면 안 됩니다.";
    public static final String SHOULD_BE_NOT_NEGATIVE_NUMBER =
        ERROR_PREFIX + "음수이면 안 됩니다.";
    public static final String SHOULD_INPUT_ONLY_NUMBER =
        ERROR_PREFIX + "숫자만을 입력해야 합니다.";
    public static final String SHOULD_NOT_INPUT_EMPTY =
        ERROR_PREFIX + "빈 값을 넣으시면 안 됩니다.";
    public static final String NAME_LENGTH_SHOULD_BE_SMALLER_THAN_FIVE =
        ERROR_PREFIX + "이름은 5자 이하여야 합니다.";
}
