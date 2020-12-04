package racingcar;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car newCar(String name) {
        return new Car(name);
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void trimName() {
        Car aCar = newCar("a");
        assertThat(newCar("a ")).isEqualTo(aCar);
        assertThat(newCar(" a")).isEqualTo(aCar);
        assertThat(newCar(" a ")).isEqualTo(aCar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateNameRange_min() {
        newCar("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateNameRange_max() {
        newCar("123456");
    }

    @Test
    public void moveForward() {
    }

    @Test
    public void printStatus() {
    }
}