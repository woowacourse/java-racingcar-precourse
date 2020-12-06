package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        try {
            Stadium stadium = new Stadium();
            stadium.readyRace(scanner);
            stadium.startRace();
        } catch (Exception e) {
            ErrorLogger.printError(e);
        }
    }
}
