package racingcar;

import java.io.PrintStream;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final PrintStream printStream = new PrintStream(System.out);

        RacingGame racingGame = new RacingGame(scanner, printStream);
        racingGame.play();
    }
}
