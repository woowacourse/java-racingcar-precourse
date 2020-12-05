package racingcar;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Request {
    private static final String SEPARATOR = ",";

    private final Scanner scanner;
    private final PrintStream printStream;

    public Request(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public ArrayList<Car> requestCarNames() {
        String input = scanner.nextLine();
        String[] carNames = input.split(SEPARATOR, -1);
        GameStatus gameStatus = ExceptionManager.checkValidCarNames(carNames);
        if (gameStatus != GameStatus.OK) {
            this.handleError(gameStatus);
        }
        return createCarsByNames(carNames);
    }

    private ArrayList<Car> createCarsByNames(String[] carNames) {
        ArrayList<Car> carList = new ArrayList<Car>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public int requestNumberStage() {
        String input = scanner.nextLine();
        GameStatus gameStatus = ExceptionManager.checkValidNumberStage(input);
        if (gameStatus != GameStatus.OK) {
            this.handleError(gameStatus);
        }
        return Integer.parseInt(input);
    }

    private void handleError(GameStatus gameStatus) {
        printStream.println(gameStatus.toString());
        throw new IllegalArgumentException();
    }
}
