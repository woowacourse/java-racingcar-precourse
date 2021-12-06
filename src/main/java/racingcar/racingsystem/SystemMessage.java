package racingcar.racingsystem;

public enum SystemMessage {
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    INPUT_NUMBER_OF_ATTEMPTS_MESSAGE("시도할 회수는 몇회인가요?\n"),
    ERROR_INPUT_CAR_NAME_MESSAGE("[ERROR] 이름은 5글자 이하, 특수문자와 공백 입력 불가하며 ',' 단위로 입력해야 합니다.\n"),
    ERROR_INPUT_NUMBER_OF_ATTEMPTS_MESSAGE("[ERROR] 시도 횟수는 숫자이며 양수만 가능합니다.\n"),
    JUDGMENT_RESULT_MESSAGE("최종 우승자 : ");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
