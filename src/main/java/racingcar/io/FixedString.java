package racingcar.io;

public enum FixedString {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ROUND_COUNT("시도할 회수는 몇회인가요?"),
    SHOW_RESULT("실행 결과"),
    WINNER("최종 우승자 : ");

    private final String content;

    FixedString(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
