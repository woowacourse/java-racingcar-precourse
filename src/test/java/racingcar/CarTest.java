package racingcar;

import org.junit.jupiter.api.Test;

public class CarTest {

    private static String name = "pobi";

    @Test
    public void testCreate() {
        Car car = new Car(name);

        car.moveOneBlock();
    }
}
