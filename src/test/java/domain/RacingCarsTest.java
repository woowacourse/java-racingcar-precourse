package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    void getRacingCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(Car.generateCar("car" + i));
        }
        RacingCars racingCars = new RacingCars(cars);
        assertArrayEquals(cars, racingCars.getRacingCars());
    }

    public void assertArrayEquals(List<Car> cars, List<Car> racingCars) {
        assertEquals(cars.size(), racingCars.size());
        for (int i = 0; i < cars.size(); i++) {
            assertEquals(cars.get(i).getCarOriginName(), racingCars.get(i).getCarOriginName());
        }
    }
}