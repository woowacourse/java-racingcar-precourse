package racingcar;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {
    private final Request request;
    private final Response response;
    private int numberRound;
    private ArrayList<Car> cars;

    public RacingGame(Scanner scanner, PrintStream printStream) {
        this.request = new Request(scanner, printStream);
        this.response = new Response(printStream);
        cars = null;
    }

    public void play() {
        this.prepare();
        this.race();
    }

    private void prepare() {
        response.printNamesRequestMessage();
        cars = request.requestCarNames();
        response.printNumberStageRequestMessage();
        numberRound = request.requestNumberRound();
        response.printEndPrepareMessage();
    }

    private void race() {
        response.printRaceStartMessage();
        for (int round = 0; round < this.numberRound; round++) {
            updateCarPositions();
        }
    }

    private void updateCarPositions() {
        for (Car car : cars) {
            if (car.isMovable()) {
                car.move();
            }
        }
    }
}
