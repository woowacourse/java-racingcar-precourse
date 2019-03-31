package racing;

import domain.Car;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarListMakerTest {

    @Test
    public void getCarListTest() {
        String input = "red,green,blue";
        List<Car> carList = CarListMaker.getList(input);

        for (Car car: carList) {
            System.out.println(car.getName());
        }
    }
}
