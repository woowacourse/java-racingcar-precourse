package racingcar.type;

public enum TextType {

    CAR_NAME_TEXT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    CAR_RACING_TIMES_TEXT("시도할 회수는 몇회인가요?"),
    COMMA(","),
    BLANK(" "),
    RESULT("실행 결과"),
    LINE("-");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
