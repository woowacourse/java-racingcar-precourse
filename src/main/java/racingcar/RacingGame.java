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
        request = new Request(scanner, printStream);
        response = new Response(printStream);
        cars = null;
    }

    public void play() {
        prepare();
        race();
        finish();
    }

    private void prepare() {
        response.printNamesRequestMessage();
        cars = request.requestCarNames();
        response.printNumberStageRequestMessage();
        numberRound = request.requestNumberRound();
        response.printPrepareEndMessage();
    }

    private void race() {
        response.printRaceStartMessage();
        for (int round = 0; round < numberRound; round++) {
            updateCarPositions();
            response.printRaceSituation(cars);
        }
    }

    private void finish() {
        Winners winners = findWinners();
        response.printWinners(winners);
    }

    private Winners findWinners() {
        Winners winners = new Winners();
        for (Car car : cars) {
            winners.updateWinners(car);
        }
        return winners;
    }

    private void updateCarPositions() {
        for (Car car : cars) {
            if (car.isMovable()) {
                car.move();
            }
        }
    }
}
