package racingcar.game.io.print;

public class OutputPrint {
    public static final String RESULT_START_MESSAGE = "실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자";

    public static void printResultStartMessage() {
        System.out.println();
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void printCarName(String name) {
        System.out.print(name + " : ");
    }

    public static void printCarState(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
    }

    public static void printWinnerMessage() {
        System.out.println(WINNER_MESSAGE);
    }
}
