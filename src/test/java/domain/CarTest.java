package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void show_currentStatus() {

        car.proceedOrStop(Car.PROCEED_BASIS_NUMBER);
        car.proceedOrStop(Car.PROCEED_BASIS_NUMBER);
        car.proceedOrStop(Car.PROCEED_BASIS_NUMBER);

        assertTrue(car.currentStatus().equals("테스트차:---"));

    }
}