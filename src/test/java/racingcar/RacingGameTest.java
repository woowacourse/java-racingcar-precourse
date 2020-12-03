package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/12/03
 */
class RacingGameTest {
    List<Car> cars = new ArrayList<>();
    RacingGame racingGame = new RacingGame(cars);
    Car yhhCar = new Car("yhh");
    Car pobi = new Car("pobi");
    Car crong = new Car("crong");


    @BeforeEach
    void setUp() {
        cars.add(yhhCar);
        cars.add(pobi);
        cars.add(crong);
    }

    @Test
    @DisplayName("단독 우승할 경우")
    void winner() {
        yhhCar.move(5);

        List<Car> winners = racingGame.findWinners();

        assertEquals(1, winners.size());
    }

    @Test
    @DisplayName("공동 우승할 경우")
    void winners() {
        yhhCar.move(5);
        crong.move(5);

        List<Car> winners = racingGame.findWinners();

        assertEquals(2, winners.size());
    }
}