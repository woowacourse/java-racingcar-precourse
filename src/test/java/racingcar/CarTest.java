package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
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

    @Test
    @DisplayName("가장 많이 전진한 자동차별로 정렬")
    void sortPosition() {
        Car yhh = new Car("yhh");
        Car pobi = new Car("pobi");

        List<Car> cars = new ArrayList<>();
        cars.add(yhh);
        cars.add(pobi);

        pobi.move(possibleMovePower);

        Collections.sort(cars);

        assertEquals("1", cars.get(0).toString());
        assertEquals("0", cars.get(1).toString());
    }
}