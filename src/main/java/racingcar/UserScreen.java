package racingcar;

public class UserScreen {
    private static final String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 1자 이상 5자 이하여야 한다.";
    private static final String SPLITTER_START_OR_END_ERROR = "[ERROR] 쉼표(,)로 시작하거나 끝나지 않아야 한다.";
    private static final String ASK_STAGE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NOT_DIGIT_ERROR = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String FIRST_DIGIT_ZERO_ERROR = "[ERROR] 시도 횟수는 0으로 시작하지 않아야 한다.";

    public static void askCarNames() {
        System.out.println(ASK_CAR_NAMES_MESSAGE);
    }

    public static void showNameLengthError() {
        System.out.println(NAME_LENGTH_ERROR);
    }

    public static void splitterStartOrEndError() {
        System.out.println(SPLITTER_START_OR_END_ERROR);
    }

    public static void askStageCount() {
        System.out.println(ASK_STAGE_COUNT_MESSAGE);
    }

    public static void showNotDigitError() {
        System.out.println(NOT_DIGIT_ERROR);
    }

    public static void showFirstDigitZeroError() {
        System.out.println(FIRST_DIGIT_ZERO_ERROR);
    }
}
