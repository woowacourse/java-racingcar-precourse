package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void initTest() {
        Car car = new Car("자동차1");
        assertThat(car).isNotNull();
    }
}