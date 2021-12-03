package racingcar.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    private Car car;

    @BeforeEach
    void init() {
        car = Car.from("pobi");
    }

    @Test
    void 한_자동차_플레이_전진() {
        Round.play(car, 4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 한_자동차_플레이_정지() {
        Round.play(car, 3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 난수_생성() {
        assertThat(Round.draw()).isInstanceOf(Integer.class);
    }
}
