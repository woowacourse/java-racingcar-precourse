package racingcar.controller;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.view.InputGuide;
import racingcar.view.OutputGuide;

/**
 * 게임이 진행되는 클래스
 */
public class Game {

    private static final String SHOW_STATUS_LOG = "실행 결과";
    private static final int MIN = 0;

    private final InputGuide inputGuide;

    private List<Car> cars;
    private int moves;

    public Game(Scanner scanner) {
        this.inputGuide = new InputGuide(scanner);
    }

    public void play() {
        init();
        race();
        OutputGuide outputGuide = new OutputGuide(cars);
        outputGuide.showResult();
    }

    private void init(){
        cars = inputGuide.inputCars();
        moves = inputGuide.countMove();
    }

    public void race() {
        System.out.println(SHOW_STATUS_LOG);
        IntStream.range(MIN, moves).forEach(value -> racePerRound());
    }

    private void racePerRound() {
        cars.forEach(Car::run);
        System.out.println();
    }

}
