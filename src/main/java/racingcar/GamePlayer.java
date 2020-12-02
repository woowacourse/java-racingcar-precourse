package racingcar;

import java.util.Scanner;

public class GamePlayer {

    public String[] inputNamesOfCars(Scanner scanner) {
        String namesOfCars = scanner.nextLine();
        return namesOfCars.split(",");
    }

    public int inputTimesToTry(Scanner scanner) {
        String timesToTry = scanner.nextLine();
        return Integer.parseInt(timesToTry);
    }
}
