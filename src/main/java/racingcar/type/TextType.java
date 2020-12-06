package racingcar.type;

/**
 * 출력 문구 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 */
public enum TextType {
    CAR_NAMES_TEXT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    CAR_RACING_TIMES_TEXT("시도할 회수는 몇회인가요?"),
    COMMA_TEXT(","),
    BLANK_TEXT(" "),
    RESULT_TEXT("실행 결과"),
    LINE_TEXT("-"),
    WINNER_TEXT("최종 우승자: ");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    /**
     * @return 출력 문구 상수
     */
    public String getText() {
        return text;
    }
}
