package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/12/03
 */
class CarTest {
    int possibleMovePower = 4;
    int impossibleMovePower = 3;

    @Test
    @DisplayName("4 이상일 경우 전진하는지")
    void move() {
        Car car = new Car("tester");
        car.move(possibleMovePower);
        car.move(possibleMovePower);
        car.move(impossibleMovePower);

        assertEquals("2", car.toString());
    }
}