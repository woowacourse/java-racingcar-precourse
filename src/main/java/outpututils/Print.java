package outpututils;

import racingcar.Car;

import java.util.ArrayList;

public class Print {
    public static void printResult(ArrayList<Car> participatedCar) {
        for (Car player : participatedCar) {
            printTurnResult(player);
        }
        System.out.println();
    }

    public static void printWinner(ArrayList<String> winners) {
        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winners));
    }

    private static void printTurnResult(Car player) {
        System.out.print(player.getName() + " : ");
        printPlayerPosition(player);
    }

    private static void printPlayerPosition(Car player) {
        for (int count = 0; count < player.getPosition(); count++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
