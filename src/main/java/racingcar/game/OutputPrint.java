package racingcar.game;

public class OutputPrint {
    public static final String RESULT_START_MESSAGE = "실행 결과";

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
}
