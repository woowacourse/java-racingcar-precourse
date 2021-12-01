package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private static List<String> winners = new ArrayList<>();

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
            winners.add(car.getName());
        }
    }

    private static void printResult() {
        String Result = "최종 우승자 : ";
        for (String name : winners) {
            Result += (name + ", ");
        }
        System.out.print(removeCommaAtEnd(Result));
    }

    private static String removeCommaAtEnd(String targetString) {
        return targetString.substring(0, targetString.length() - 2);
    }
}
