package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnersTest {

    @Test
    void getWinners() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(Car.generateCar("car" + i));
        }
        Winners winners = new Winners(cars);
        assertArrayEquals(cars, winners.getWinners());
    }

    @Test
    void getWinnersSize() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(Car.generateCar("car" + i));
        }
        Winners winners = new Winners(cars);
        assertEquals(cars.size(), winners.getWinnersSize());
    }

    public void assertArrayEquals(List<Car> cars, List<Car> racingCars) {
        assertEquals(cars.size(), racingCars.size());
        for (int i = 0; i < cars.size(); i++) {
            assertEquals(cars.get(i).getCarOriginName(), racingCars.get(i).getCarOriginName());
        }
    }
}