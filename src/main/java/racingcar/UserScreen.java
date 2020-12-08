package racingcar;

import java.util.ArrayList;

public class UserScreen {
    private static final String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름은 1자 이상 5자 이하여야 한다.";
    private static final String SPLITTER_START_OR_END_ERROR = "[ERROR] 쉼표(,)로 시작하거나 끝나지 않아야 한다.";
    private static final String ASK_STAGE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NOT_DIGIT_ERROR = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private static final String FIRST_DIGIT_ZERO_ERROR = "[ERROR] 시도 횟수는 0으로 시작하지 않아야 한다.";
    private static final String SIMULATE_START_MESSAGE = "\n실행 결과";
    private static final String EMPTY_OR_NULL_ERROR = "[ERROR] 입력을 해야 한다.";
    private static final String NOT_ALPHABETIC_ERROR = "[ERROR] 이름은 알파벳이여야 한다.";
    private static final String NAMES_ARE_NOT_DIFFERENT_ERROR = "[ERROR] 이름은 서로 달라야 한다.";

    public static void askCarNames() {
        System.out.println(ASK_CAR_NAMES_MESSAGE);
    }

    public static void showNameLengthError() {
        System.out.println(NAME_LENGTH_ERROR);
    }

    public static void showSplitterStartOrEndError() {
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

    public static void showSimulateStart() {
        System.out.println(SIMULATE_START_MESSAGE);
    }

    public static void showNotAlphabeticError() {
        System.out.println(NOT_ALPHABETIC_ERROR);
    }

    public static void showEmptyOrNullError() {
        System.out.println(EMPTY_OR_NULL_ERROR);
    }

    public static void showNamesAreNotDifferentError() {
        System.out.println(NAMES_ARE_NOT_DIFFERENT_ERROR);
    }

    public static void showStageResult(Car[] cars) {
        for (Car car : cars) {
            String name = car.getName();
            String positionLine = car.getPositionLine();
            System.out.println(name + " : " + positionLine);
        }

        System.out.println();
    }

    public static void showGameResult(ArrayList<String> winners) {
        StringBuilder gameResultMessage = new StringBuilder("최종 우승자: ");

        for (int i = 0; i < winners.size(); i++) {
            gameResultMessage.append(winners.get(i));

            if (i != winners.size() - 1) {
                gameResultMessage.append(", ");
            }
        }

        System.out.println(gameResultMessage.toString());
    }
}
