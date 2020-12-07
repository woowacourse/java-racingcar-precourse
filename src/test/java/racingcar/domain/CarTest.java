package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.engine.FixedEngine;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_움직임_및_현재상태출력_테스트() {
        // given
        Car car = new Car("pobi");

        // when
        int numOfMoving = 5;
        for (int i = 0; i < numOfMoving; i++) {
            car.move(new FixedEngine(9));
        }

        // then
        assertEquals("pobi : -----", car.toString());
    }
}