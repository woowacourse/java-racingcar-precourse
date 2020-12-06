package racingcar.controller;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.exception.RacingCarErrorException;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * 게임이 진행되는 클래스
 */
public class Game {

    private static final String NO_WINNERS_EXCEPTION_MESSAGE = "우승자가 존재하지 않습니다.";
    private static final String DELIMITER = ", ";
    private static final int MIN = 0;

    private final InputView inputView;
    private final OutputView outputView;

    private List<Car> cars;
    private int moves;

    public Game(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
    }

    public void play() {
        initialize();
        race();
        outputView.showWinner(findWinner());
    }

    private void initialize() {
        cars = makeCars(inputView.inputCars());
        moves = inputView.inputMoves();
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void race() {
        outputView.showResult();
        IntStream.range(MIN, moves).forEach(value -> racePerRound());
    }

    private void racePerRound() {
        cars.forEach(Car::run);
        cars.forEach(car -> outputView.drawTrace(car.getName(),car.getPosition()));
        System.out.println();
    }

    private String findWinner() {
        int max = findMaxMove();
        return cars.stream()
            .filter(car->car.isOnPosition(max))
        .map(Car::getName)
        .collect(Collectors.joining(DELIMITER));
    }

    private int findMaxMove() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new RacingCarErrorException(NO_WINNERS_EXCEPTION_MESSAGE));
    }
}
