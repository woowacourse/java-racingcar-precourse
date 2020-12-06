package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {
    final static String WINNER_IS = "최종 우승자: ";

    public GameStatus() {
    }

    public static void printWinner(RacingCars racingCars) {
        List<String> winners = new ArrayList<>();
        for (int carIndex = 0; carIndex < racingCars.getTotalNumberOfCars(); carIndex++) {
            if (racingCars.getCar(carIndex).isWinner(racingCars.getMaxPosition())) {
                winners.add(racingCars.getCar(carIndex).getName());
            }
        }

        System.out.print(WINNER_IS);
        System.out.println(String.join(", ", winners));
    }

    public static void printStatus(RacingCars racingCars) {
        for (int carIndex = 0; carIndex < racingCars.getTotalNumberOfCars(); carIndex++) {
            printName(racingCars, carIndex);
            printPosition(racingCars, carIndex);
        }
        System.out.print("\n");
    }

    private static void printName(RacingCars racingCars, int carIndex) {
        System.out.print(racingCars.getCar(carIndex).getName() + " : ");
    }

    private static void printPosition(RacingCars racingCars, int carIndex) {
        for (int pos = 0; pos < racingCars.getCar(carIndex).getPosition(); pos++) {
            System.out.print('-');
        }
        System.out.print("\n");
    }
}
