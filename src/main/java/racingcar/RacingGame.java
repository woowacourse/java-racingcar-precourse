package racingcar;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {
    private final Request request;
    private final Response response;
    private int numberStage;
    private ArrayList<Car> cars;

    public RacingGame(Scanner scanner, PrintStream printStream) {
        this.request = new Request(scanner, printStream);
        this.response = new Response(printStream);
        cars = null;
    }

    public void start() {
        response.printNamesRequestMessage();
        cars = request.requestCarNames();
        response.printNumberStageRequestMessage();
        numberStage = request.requestNumberStage();
    }
}
