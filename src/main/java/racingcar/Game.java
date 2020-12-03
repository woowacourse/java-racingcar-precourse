package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Game {
    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;
    private final OutputView outputView;
    private ArrayList<Car> cars;
    private ScoreBoard scoreboard;

    public Game() {
        cars = new ArrayList<>();
        outputView = new OutputView();
    }

    public void enter(Car car) {
        cars.add(car);
    }

    public void play(int round) {
        scoreboard = new ScoreBoard(cars);
        outputView.printResultMessage();
        IntStream.range(0,round).forEach(i -> playSinglePhase());
        outputView.printWinners(scoreboard);
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
