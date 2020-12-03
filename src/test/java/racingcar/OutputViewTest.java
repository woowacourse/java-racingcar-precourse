package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private OutputView outputView;
    private ScoreBoard scoreBoard;
    @BeforeEach
    void initOutputView() {
        outputView = new OutputView();
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        ArrayList<Car> cars = new ArrayList<>();
        scoreBoard = new ScoreBoard(cars);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        car1.move();
        car2.move();
    }
    @Test
    void printResultMessage() {
        outputView.printResultMessage();
    }

    @Test
    void printResult() {
        outputView.printResult(scoreBoard);
    }

    @Test
    void printWinners() {
        outputView.printWinners(scoreBoard);
    }
}