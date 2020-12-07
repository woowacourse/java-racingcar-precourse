package racingcar;

import org.junit.jupiter.api.Test;

public class CarTest {

    private static final String name = "pobi";
    private static final String secondname = "json";

    @Test
    public void testCreate() {
        Car car = Car.newCar(name);
        car.tryForward();

        Car secondCar = Car.newCar(secondname);
        secondCar.tryForward();
        secondCar.tryForward();
        secondCar.tryForward();
    }

    @Test
    public void testGasTankInstance() {
        Car car1 = Car.newCar("poriri1");
        Car car2 = Car.newCar("poriri2");
        Car car3 = Car.newCar("poriri3");

        for (int i = 0; i < 3; i++) {
            car1.tryForward();
            car2.tryForward();
            car3.tryForward();
            System.out.println("---------------------");
        }
    }
}
