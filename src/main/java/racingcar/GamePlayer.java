package racingcar;

import java.util.Scanner;

public class GamePlayer {

    public String[] inputNamesOfCars(Scanner scanner) {
        String namesOfCars = scanner.nextLine();
        return namesOfCars.split(",");
    }

    public int inputTimeToTry(Scanner scanner) {
        String timeToTry = scanner.nextLine();
        return Integer.parseInt(timeToTry);
    }
}
