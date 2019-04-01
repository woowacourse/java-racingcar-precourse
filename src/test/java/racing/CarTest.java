package racing;

import domain.Car;
import org.junit.Test;

public class CarTest {

    @Test
    public void carMoveTest() {
        Car car = new Car("icarus");

        car.move();
        car.move();
        car.move();
        car.printPosition();
    }
}
