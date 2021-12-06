package racingcar;

import racingcar.io.ConsolePrinter;
import racingcar.io.ConsoleReader;

public class Application {
    public static void main(String[] args) {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        ConsoleReader consoleReader = new ConsoleReader(consolePrinter);
    }
}
