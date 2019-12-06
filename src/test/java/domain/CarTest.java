package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void race() {
    }

    @Test
    void equals() {
        //given
        Car car = new Car("rightName");
        Car sameCar = new Car("rightName");

        // when & then
        assertEquals(sameCar, car);

        //given
        Car differentCar = new Car("wrongName");
        assertNotEquals(differentCar, car);
    }
}