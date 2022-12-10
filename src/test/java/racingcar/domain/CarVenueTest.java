package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarVenueTest {
    @Test
    public void printTurnTest() throws Exception{
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("hi"));
        cars.add(new Car("bye"));
        cars.add(new Car("hello"));
        CarVenue carVenue = new CarVenue(cars, 3);

    }
}