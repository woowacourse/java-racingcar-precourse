package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    private static final String name = "pobi";
    private static final String secondname = "json";

    @Test
    public void testCreate() {
        Car car = Car.makeRandomForwardCar(name);
        car.tryForward();
        assertThat(car.getPosition()).isEqualTo(1);

        Car secondCar = Car.makeRandomForwardCar(secondname);
        secondCar.tryForward();
        secondCar.tryForward();
        secondCar.tryForward();
        assertThat(secondCar.getPosition()).isEqualTo(3);
    }

    @Test
    public void testGasTankInstance() {
        Car car1 = Car.makeRandomForwardCar("poriri1");
        Car car2 = Car.makeRandomForwardCar("poriri2");
        Car car3 = Car.makeRandomForwardCar("poriri3");

        for (int i = 0; i < 3; i++) {
            car1.tryForward();
            System.out.println(car1.getPosition());
            car2.tryForward();
            System.out.println(car2.getPosition());
            car3.tryForward();
            System.out.println(car3.getPosition());
            System.out.println("---------------------");
        }
    }
}
