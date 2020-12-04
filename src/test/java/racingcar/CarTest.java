package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

    private Car getCar(String name) {
        return new Car(name);
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void trimName() {
        Car a = getCar("a");
        assertThat(getCar("a ")).isEqualTo(a);
        assertThat(getCar(" a")).isEqualTo(a);
        assertThat(getCar(" a ")).isEqualTo(a);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateNameRange_min() {
        getCar("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateNameRange_max() {
        getCar("123456");
    }

    @Test
    public void moveForward() {
    }

    @Test
    public void printStatus() {
    }
}