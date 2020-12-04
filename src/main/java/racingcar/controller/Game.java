package racingcar.controller;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.exception.RacingCarErrorException;
import racingcar.model.Car;
import racingcar.view.InputGuide;
import racingcar.view.OutputGuide;

/**
 * 게임이 진행되는 클래스
 */
public class Game {

    private static final int MIN = 0;
    private static final String DELIMITER = ", ";
    private static final String NO_WINNERS_EXCEPTION_MESSAGE = "우승자가 존재하지 않습니다.";

    private final InputGuide inputGuide;
    private final OutputGuide outputGuide;

    private List<Car> cars;
    private int moves;

    public Game(Scanner scanner) {
        this.inputGuide = new InputGuide(scanner);
        this.outputGuide = new OutputGuide();
    }

    public void play() {
        init();
        race();
        outputGuide.showWinner(findWinner());
    }

    private void init() {
        cars = makeCars(inputGuide.inputCars());
        moves = inputGuide.inputMoves();
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void race() {
        outputGuide.showResult();
        IntStream.range(MIN, moves).forEach(value -> racePerRound());
    }

    private void racePerRound() {
        cars.forEach(Car::run);
        System.out.println();
    }

    private String findWinner() {
        int max = findMaxMove();
        StringBuilder stringBuilder = new StringBuilder();
        cars.stream()
            .filter(car -> car.getPosition() == max)
            .forEach(car -> stringBuilder.append(car.getName()).append(DELIMITER));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(DELIMITER));
        return stringBuilder.toString();
    }

    private int findMaxMove() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new RacingCarErrorException(NO_WINNERS_EXCEPTION_MESSAGE));
    }
}
