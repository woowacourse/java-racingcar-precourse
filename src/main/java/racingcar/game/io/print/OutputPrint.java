package racingcar.game.io.print;

public class OutputPrint {
    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자: ";
    private static final String NAME_RESULT_DELIMITER = " : ";
    private static final char CAR_MOVE_ONE_SPACE = '-';

    public static void printResultStartMessage() {
        System.out.println();
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void printCarName(String name) {
        System.out.print(name + NAME_RESULT_DELIMITER);
    }

    public static void printCarState(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_MOVE_ONE_SPACE);
        }
    }

    public static void printWinnerMessage() {
        System.out.print(WINNER_MESSAGE);
    }
}
