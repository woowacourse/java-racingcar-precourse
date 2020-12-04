package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Game {
    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;
    private final InputView inputView;
    private final OutputView outputView;
    private final ArrayList<Car> cars;
    private ScoreBoard scoreBoard;
    private int runCount;

    public Game(Scanner scanner) {
        cars = new ArrayList<>();
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }

    public void play() {
        updateCarNames();
        updateRunCount();
        outputView.printResultMessage();
        playRunCountTimes();
        outputView.printWinners(scoreBoard);
    }

    private void enter(Car car) {
        cars.add(car);
    }

    private void enter(String carName) {
        Car car = new Car(carName);
        enter(car);
    }

    private void updateCarNames() {
        try {
            outputView.printCarNameQuestion();
            inputView.getCarNames().forEach(this::enter);
            scoreBoard = new ScoreBoard(cars);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            updateCarNames();
        }
    }

    private void updateRunCount() {
        try {
            outputView.printRunCountQuestion();
            runCount = inputView.getRunCount();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            updateRunCount();
        }
    }

    private void playRunCountTimes() {
        IntStream.range(0, runCount).forEach(i -> playOneTime());
    }

    private void playOneTime() {
        playMoveOrStop();
        outputView.printResult(scoreBoard);
    }

    private void playMoveOrStop() {
        cars.forEach(this::playMoveOrStop);
    }

    private void playMoveOrStop(Car car) {
        if (randomGameNumber() >= 4) {
            car.move();
        }
    }

    private int randomGameNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
