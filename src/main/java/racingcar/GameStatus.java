package racingcar;

public enum GameStatus {
    OK("에러가 발생하지 않았습니다."), 
    DUPLICATED_NAME("중복된 이름이 존재하면 안됩니다."),
    INVALID_NAME_LENGTH("이름의 길이가 " + ExceptionManager.MINIMUM_CAR_NAME_LENGTH + "이상 "
            + ExceptionManager.MAXIMUM_CAR_NAME_LENGTH
            + "이하여야 됩니다."), 
    INVALID_NUMBER_ROUND_TYPE("시도 횟수는 숫자여야 합니다."),
    INVALID_NUMBER_ROUND_RANGE("가능한 이동 회수는 " + ExceptionManager.MINUMUM_NUMBER_ROUND + "이상 "
            + ExceptionManager.MAXIMUM_NUMBER_ROUND + "이하여야 됩니다.");

    private final String errorMessageFormat = "[ERROR] %s";
    private final String message;

    GameStatus(String message) {
        this.message = String.format(errorMessageFormat, message);
    }

    public String toString() {
        return this.message;
    }
}
