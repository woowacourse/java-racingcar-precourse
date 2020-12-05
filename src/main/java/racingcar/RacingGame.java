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
        this.finish();
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
        for (int round = 0; round < this.numberRound; round++) {
            updateCarPositions();
            response.printRaceSituation(cars);
        }
    }

    private void finish() {
        ArrayList<Car> winners = this.findWinners();
    }

    private ArrayList<Car> findWinners() {
        ArrayList<Car> result = null;
        int maxPosition = -1;
        for (Car car : cars) {
            int carPosition = car.getPosition();
            if (maxPosition == carPosition) {
                // 최대값일 경우 우승자 리스트에 추가한다.
                result.add(car);
            } else if (maxPosition < carPosition) {
                // 현재 최대값보다 더 멀리간 자동차가 있을 경우 최대값을 갱신하고 우승자 리스트를 새로 만든다.
                maxPosition = carPosition;
                result = new ArrayList<Car>();
            }
        }
        return result;
    }

    private void updateCarPositions() {
        for (Car car : cars) {
            if (car.isMovable()) {
                car.move();
            }
        }
    }
}
