package racingcar.type;

/**
 * ErrorType.java : 에러 문구 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum ErrorType {
    ERROR("[ERROR] "),
    INVALID_LENGTH(ERROR.getError() + "자동차 이름의 길이가 1자 이상 5자 이하가 되도록 입력해주세요."),
    INVALID_FORMAT(ERROR.getError() + "자동차 이름은 공백 없이 입력해주세요."),
    INVALID_DUPLICATION(ERROR.getError() + "자동차 이름이 중복되지 않게 입력해주세요."),
    INVALID_CHARACTER(ERROR.getError() + "시도할 횟수는 숫자로 입력해주세요."),
    INVALID_ZERO_TIME(ERROR.getError() + "시도할 횟수는 1 이상으로 입력해주세요."),
    NO_WINNER(ERROR.getError() + "게임 우승자가 없습니다.");

    private final String error;

    ErrorType(String error) {
        this.error = error;
    }

    /**
     * @return 에러 문구 상수
     */
    public String getError() {
        return error;
    }
}
