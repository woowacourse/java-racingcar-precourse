package racingcar;

public class GameStatus {

    public GameStatus() {
    }

    public static void printStatus(RacingCars racingCars) {
        for (int carIndex = 0; carIndex < racingCars.getTotalNumberOfCars(); carIndex++) {
            printName(racingCars, carIndex);
            printPosition(racingCars, carIndex);
        }
        System.out.print("\n");
    }

    private static void printName(RacingCars racingCars, int carIndex) {
        System.out.print(racingCars.getCarName(carIndex) + " : ");
    }

    private static void printPosition(RacingCars racingCars, int carIndex) {
        for (int pos = 0; pos < racingCars.getCarPosition(carIndex); pos++) {
            System.out.print('-');
        }
        System.out.print("\n");
    }
}
