package racingcar.constant;

public enum SystemMessage {
    GET_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GET_TRY_NUMBER_MESSAGE("시도할 회수는 몇회인가요?");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
