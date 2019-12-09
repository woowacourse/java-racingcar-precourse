package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    private Car car = new Car("테스트차");

    @Test
    void check_proceedOrStop() {

        int previousPosition = car.getPosition();
        car.proceedOrStop(3);

        assertTrue(car.getPosition() == previousPosition);

        car.proceedOrStop(Car.PROCEED_BASIS_NUMBER);

        assertTrue(car.getPosition() == previousPosition + 1);

    }
}
