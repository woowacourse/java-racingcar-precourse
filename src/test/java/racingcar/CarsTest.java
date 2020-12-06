package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    public void findMaxPositionCarsTest(){
        //given
        List<String> carsList = Arrays.asList("BJ", "YJ", "AJ");
        Cars cars = new Cars(carsList);
        //when
        do {
            cars.moveByRandomNumber();
        } while (cars.findMaxPositionCars().size() != 2);
        List<Car> result = cars.findMaxPositionCars();
        //then
        assertEquals(0, result.get(0).compareTo(result.get(1)));
    }
}