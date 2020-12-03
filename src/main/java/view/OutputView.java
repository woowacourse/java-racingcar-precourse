package view;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String MOVE_SIGN = "-";

    public static void printInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputRaceTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRaceResult() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public static void printRaceResultEachCar(String name, int position) {
        System.out.print(name + " : " );

        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_SIGN);
        }

        System.out.println();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinner(List<String> names) {
        System.out.print("최종 우승자 : ");

        System.out.println(String.join(", ", names));
    }
}
