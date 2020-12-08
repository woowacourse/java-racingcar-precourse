package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {
    ScoreBoard scoreBoard;
    private ArrayList<Car> cars;
    Car car1;
    Car car2;
    Car car3;
    @BeforeEach
    void initScoreBoard() {
        cars = new ArrayList<>();
        scoreBoard = new ScoreBoard(cars);
        car1 = new Car("a");
        car2 = new Car("b");
        car3 = new Car("c");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @Test
    void getResult() {
        car1.move();
        assertEquals(scoreBoard.getResult().get(0).getPosition(),cars.get(0).getPosition());
    }

    @Test
    void getWinners() {
        car1.move();
        car2.move();
        assertEquals(scoreBoard.getWinners().get(0).getName(), "a");
        assertEquals(scoreBoard.getWinners().get(1).getName(), "b");
    }
}