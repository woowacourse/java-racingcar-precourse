package racingcar;

import java.util.Scanner;

public class GamePlayer {

    public static String[] inputNamesOfCars(Scanner scanner) {
        String namesOfCars = scanner.nextLine();
        String[] namesOfCarsArray = namesOfCars.split(",");
        return namesOfCarsArray;
    }
}
