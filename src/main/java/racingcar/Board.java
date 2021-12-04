package racingcar;

import java.util.List;

public class Board {

    public static void showStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.showPosition());
        }
        System.out.println();
    }

    public static void showResult(List<Car> winners) {
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
