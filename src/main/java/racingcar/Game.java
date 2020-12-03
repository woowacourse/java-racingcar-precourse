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
    private ArrayList<Car> cars;
    private ScoreBoard scoreboard;
    private int round;

    public Game(Scanner scanner) {
        cars = new ArrayList<>();
        inputView = new InputView(scanner);
        outputView = new OutputView();
    }

    public void play() {
        updateCarName();
        updateRoundNumber();
        scoreboard = new ScoreBoard(cars);
        outputView.printResultMessage();
        IntStream.range(0,round).forEach(i -> playSinglePhase());
        outputView.printWinners(scoreboard);
    }

    private void enter(Car car) {
        cars.add(car);
    }

    private void enter(String carName) {
        Car car = new Car(carName);
        enter(car);
    }

    private void updateCarName() {
        outputView.printCarNameQuestion();
        inputView.getCarNames().forEach(this::enter);
    }

    private void updateRoundNumber() {
        outputView.printRoundNumberQuestion();
        round = inputView.getRoundNumber();
    }

    private void playSinglePhase() {
        playSingleRound();
        outputView.printResult(scoreboard);
    }

    private void playSingleRound() {
        cars.forEach(this::playSingleRound);
    }

    private void playSingleRound(Car car) {
        if (randomGameNumber() <= 4) {
            car.move();
        }
    }

    private int randomGameNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
