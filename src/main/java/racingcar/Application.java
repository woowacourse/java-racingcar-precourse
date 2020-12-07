package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // Test
        Race race = new Race();
        race.startRace(scanner);
        race.runRace();
        race.printWinnerList();
    }
}
