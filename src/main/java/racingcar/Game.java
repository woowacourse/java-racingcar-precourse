package racingcar;

import java.util.Scanner;

/**
 * 게임이 진행되는 클래스
 */
public class Game {

    private final InputGuide inputGuide;
    private OutputGuide outputGuide;

    Game(Scanner scanner) {
        this.inputGuide = new InputGuide(scanner);
    }

    public void play() {
        Car[] cars = inputGuide.inputCars();
        int moves = inputGuide.countMove();
        outputGuide = new OutputGuide(cars, moves);
        outputGuide.showResult();
    }


}
