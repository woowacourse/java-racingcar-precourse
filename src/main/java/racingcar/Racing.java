package racingcar;

import java.util.Scanner;

public class Racing {

    public void start(Scanner scanner) {
        Cars cars = entryCars(scanner);
        Lap lap = entryLap(scanner);

        View.printStartRacing();
        while (!lap.isEnd()) {
            View.printRacing(cars.continueRacing());
        }
        View.printWinners(cars.awardWinners());
    }

    private Cars entryCars(Scanner scanner) {
        while (true) {
            try {
                View.printPleaseInputCars();
                return Cars.newCars(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                View.printError(e.getMessage());
            }
        }
    }

    private Lap entryLap(Scanner scanner) {
        while (true) {
            try {
                View.printPleaseInputLap();
                return Lap.newLap(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                View.printError(e.getMessage());
            }
        }
    }
}
