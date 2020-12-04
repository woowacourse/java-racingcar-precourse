package racingcar.domain.exception;

public class DuplicateNameException extends ValidationException {

    public static final String DUPLICATE_NAME_MESSAGE = "자동차 이름 %s는 중복된 이름입니다.";

    public DuplicateNameException(String duplicateCarName) {
        super(String.format(DUPLICATE_NAME_MESSAGE, duplicateCarName));
    }
}
