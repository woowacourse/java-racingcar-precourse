package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class WinnersTest {

    Car a, b, c;

    @Before
    public void setUp() throws Exception {
        a = new Car("a");
        b = new Car("b");
        c = new Car("c");
    }

    @Test
    public void getWinnerNames_multiWinners() {
        Winners gameResult = new Winners(
                Arrays.asList(a, b));

        assertThat(gameResult.getWinnerNames()).isEqualTo("a, b");
    }

    @Test
    public void getWinnerNames_singleWinner() {
        Winners gameResult = new Winners(
                Collections.singletonList(a));

        assertThat(gameResult.getWinnerNames()).isEqualTo("a");
    }

    @Test
    public void getWinners() {
        List<Car> cars = Arrays.asList(a, b, c);
        a.moveForward();

        Car car = new Car("a");
        car.moveForward();
        Winners winners = new Winners(Collections.singletonList(car));
        assertThat(Winners.getWinners(cars)).isEqualTo(winners);
    }
}