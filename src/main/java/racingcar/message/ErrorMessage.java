package racingcar.message;

public enum ErrorMessage {
    INVALID_CAR_NAME("자동차이름은 5자 이하만 가능합니다."),
    INVALID_CAR_GROUP("잘못된 CarGroup을 참조하고 있습니다."),
    GROUP_CANNOT_HAVE_DUPLICATED_CAR("중복된 이름의 자동차는 존재할 수 없습니다."),
    TRY_COUNT_MUST_BE_NUMBER("시도 횟수는 숫자여야 합니다.");

    public final String message;
    private static final String prefix = "[ERROR]";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.join(" ", prefix, message);
    }
}
