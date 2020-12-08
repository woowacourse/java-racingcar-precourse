package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void fromTest() {
        Car car = Car.from("pobi");
    }

    @Test
    public void compareTest() {
        Car car1 = Car.from("pobi");
        Car car2 = Car.from("crong");
        IntStream.rangeClosed(0, Integer.MAX_VALUE / 1024)
                .forEach(i -> car2.move()); // 높은 확률로
        assertThat(car1.compareTo(car2)).isEqualTo(-1);
    }
}
