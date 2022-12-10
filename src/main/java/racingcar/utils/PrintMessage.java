package racingcar.utils;

public enum PrintMessage {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
    PRINT_BEFORE_RACING_RESULT("실행 결과"),
    PRINT_WINNER("최종 우승자 : %s");

    public final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
