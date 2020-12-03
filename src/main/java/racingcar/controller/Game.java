package racingcar.controller;

import java.util.List;
import java.util.Scanner;
import racingcar.model.Car;
import racingcar.view.InputGuide;
import racingcar.view.OutputGuide;

/**
 * 게임이 진행되는 클래스
 */
public class Game {

    private final InputGuide inputGuide;

    public Game(Scanner scanner) {
        this.inputGuide = new InputGuide(scanner);
    }

    public void play() {
        List<Car> cars = inputGuide.inputCars();
        int moves = inputGuide.countMove();
        OutputGuide outputGuide = new OutputGuide(cars, moves);
        outputGuide.showResult();
    }
}
