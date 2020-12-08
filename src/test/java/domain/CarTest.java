package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

class CarTest {
    @Test
    void 자동차_정지_테스트() {
        Car car = new Car("one");
        for (int i = 0; i < 10; i++) {
            car.moveCar(RandomUtils.nextInt(0, 3));
            Assertions.assertEquals(0, car.getPosition());
        }
    }

    @Test
    void 자동차_전진_테스트() {
        for (int i = 0; i < 10; i++) {
            Car car = new Car("one");
            car.moveCar(RandomUtils.nextInt(4, 9));
            Assertions.assertEquals(1, car.getPosition());
        }
    }
}