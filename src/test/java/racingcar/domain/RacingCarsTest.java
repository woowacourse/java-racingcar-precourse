package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.engine.FixedEngine;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    void 가장_빠른_자동차_2대_테스트() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        RacingCars racingCars = new RacingCars(Arrays.asList(car1, car2));

        // when
        int numOfMove = 4;
        for (int i = 0; i < numOfMove; i++) {
            racingCars.move(new FixedEngine(9));
        }

        // then
        List<Car> fastestCars = racingCars.getFastestCars();
        assertEquals("pobi", fastestCars.get(0).getName());
        assertEquals("woni", fastestCars.get(1).getName());
    }

    @Test
    void 가장_빠른_자동차_1대_테스트() {
        // given
        FixedEngine fixedEngine = new FixedEngine(9);
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move(fixedEngine);

        // when
        RacingCars racingCars = new RacingCars(Arrays.asList(car1, car2));
        int numOfMove = 4;
        for (int i = 0; i < numOfMove; i++) {
            racingCars.move(fixedEngine);
        }

        // then
        List<Car> fastestCars = racingCars.getFastestCars();
        assertEquals("pobi", fastestCars.get(0).getName());
    }

}