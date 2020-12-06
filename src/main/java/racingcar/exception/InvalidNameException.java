package racingcar.exception;

import racingcar.domain.setting.CarSetting;

public class InvalidNameException extends RuntimeException {

    private static final String ERROR_MESSAGE = String.format("[ERROR] 이름은 1~%d자 이상만 입력 가능합니다."
            , CarSetting.NAME_MAX_LENGTH.get());
    private static final String DUPLICATE_NAME_MESSAGE = "[ERROR] 중복된 이름이 있습니다.";

    public InvalidNameException() {
        super(ERROR_MESSAGE);
    }

    public InvalidNameException(String[] names) {
        super(DUPLICATE_NAME_MESSAGE);
    }

}
