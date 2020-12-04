package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    private static String name = "pobi";
    private static String secondname = "json";

    @Test
    public void testCreate() {
        Car car = new Car(name);
        car.addPosition();
        assertThat(car.getPosition()).isEqualTo(1);

        Car secondCar = new Car(secondname);
        secondCar.addPosition();
        secondCar.addPosition();
        secondCar.addPosition();
        assertThat(secondCar.getPosition()).isEqualTo(3);
    }
}
