package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    public void printCarPositionTest() throws Exception {
        Car car = new Car("bebe");
        car.move(5);
        car.move(4);
        car.move(1);
        Assertions.assertEquals(car.toString(), "bebe : --");
    }

    @Test
    public void carNameTest() throws Exception {
        assertThatThrownBy(() ->
                new Car("ffffff")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                new Car("")).isInstanceOf(IllegalArgumentException.class);
    }

}