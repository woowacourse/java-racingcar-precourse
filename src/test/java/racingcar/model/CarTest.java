package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_포지션_대쉬로_변환_기능() {
        Car car = new Car("test");
        car.forward();
        car.forward();
        car.forward();
        String convertedPosition = car.positionConvertToDash();

        assertThat(convertedPosition).isEqualTo("---");
    }
}