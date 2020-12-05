package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    private static String name = "pobi";
    private static String secondname = "json";

    @Test
    public void testCreate() {
        Car car = new Car(name, new GasTank());
        car.tryForward();
        assertThat(car.getPosition()).isEqualTo(1);

        Car secondCar = new Car(secondname, new GasTank());
        secondCar.tryForward();
        secondCar.tryForward();
        secondCar.tryForward();
        assertThat(secondCar.getPosition()).isEqualTo(3);
    }

    @Test
    public void testGasTankInstance() {
        Car car1 = new Car("porori1", new GasTank());
        Car car2 = new Car("porori2", new GasTank());
        Car car3 = new Car("porori3", new GasTank());

        for (int i = 0; i < 3; i++) {
            car1.tryForward();
            System.out.println(car1.getPosition());
            car2.tryForward();
            System.out.println(car2.getPosition());
            car3.tryForward();
            System.out.println(car3.getPosition());
            System.out.println("---------------------");
        }

        System.out.println(car1.gasTank);
        System.out.println(car2.gasTank);
        System.out.println(car3.gasTank);
    }
}
