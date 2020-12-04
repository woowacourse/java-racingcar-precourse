package racingcar;

public class UserScreen {
    private static final String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NAME_LENGTH_ERROR = "이름은 5자 이하여야 한다.";
    private static final String SPLITTER_START_OR_END_ERROR = "쉼표(,)로 시작하거나 끝나지 않아야 한다.";

    public static void askCarNames() {
        System.out.println(ASK_CAR_NAMES_MESSAGE);
    }

    public static void showNameLengthError() {
        System.out.println(NAME_LENGTH_ERROR);
    }

    public static void splitterStartOrEndError() {
        System.out.println(SPLITTER_START_OR_END_ERROR);
    }
}
