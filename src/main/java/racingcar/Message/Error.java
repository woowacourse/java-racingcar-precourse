package racingcar.Message;

public enum Error {
    NOT_ONLY_ONE_ATTENDED("참가하는 자동차가 한대 이하일 경우 경기를 진행할 수 없습니다."),
    NOT_ALLOWED_BLANK_OF_NAME("이름에 공백이 들어갈 수 없습니다."),
    NOT_NUMBER_INPUT_COUNT("횟수는 숫자여야합니다."),
    NOT_NUMBER_ALLOWED_UNDER_ZERO("1이상의 숫자만 입력 가능합니다."),
    NOT_PROPER_NAME_LENGTH("이름은 1자 이상, 5자 이하여야 합니다."),
    DUPLICATED_NAMES("중복된 이름이 있습니다. (중복이름 : %s)\n");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "[ERROR] " + this.error;
    }

    public String toString(String name) {
        return "[ERROR] " + String.format(this.error, name);
    }
}
