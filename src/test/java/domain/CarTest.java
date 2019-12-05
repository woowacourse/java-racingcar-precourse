package domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void initTest() {
        Car car = new Car("자동차1");
        assertThat(car).isNotNull();
    }

    @Test
    public void randomGeneratorTest() {
        IntStream.range(1, 1000).mapToObj(x -> new Car("").randomGenerator())
                .forEach(x -> assertThat(x).isBetween(0, 9));
    }
}