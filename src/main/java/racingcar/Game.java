package racingcar;

import racingcar.View.InputView;
import racingcar.View.OutputView;
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
    private int round;

    public Game(Scanner scanner) {
        cars = new ArrayList<>();
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }

    public void play() {
        updateCarNames();
        updateRound();
        playMultipleRound();
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
            inputView.getCarNames()
                     .forEach(this::enter);
            scoreBoard = new ScoreBoard(cars);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            updateCarNames();
        }
    }

    private void updateRound() {
        try {
            outputView.printRoundQuestion();
            round = inputView.getRound();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            updateRound();
        }
    }

    private void playMultipleRound() {
        outputView.printResultMessage();
        IntStream.range(0, round)
                 .forEach(i -> playSingleRound());
    }

    private void playSingleRound() {
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
