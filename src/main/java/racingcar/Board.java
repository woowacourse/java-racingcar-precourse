package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static List<Car> winners = new ArrayList<>();

    public static void showStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.showPosition());
        }
        System.out.println();
    }

    public static void showResult(List<Car> cars) {
        decideWinner(cars);
        printResult();
    }

    private static void decideWinner(List<Car> cars) {
        int maxPosition = GameUtil.findMax(cars);
        for (Car car : cars) {
            isWinner(maxPosition, car);
        }
    }

    private static void isWinner(int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private static void printResult() {
        String Result = SystemMessage.WINNER_MESSAGE;
        for (Car car : winners) {
            Result += (car.getName() + SystemMessage.SEPARATOR);
        }
        System.out.print(removeSEPARATORAtEnd(Result));
    }

    private static String removeSEPARATORAtEnd(String targetString) {
        return targetString.substring(0, targetString.length() - 2);
    }
}
