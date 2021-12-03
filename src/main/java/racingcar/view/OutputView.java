package racingcar.view;

import racingcar.constant.SystemMessage;

public class OutputView {
    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printCarName(String name) {
        System.out.print(name + " : ");
    }

    public static void printCarPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
    }

    public static void printSpace() {
        System.out.println();
    }

    public static void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
