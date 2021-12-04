package racingcar.domain.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    private Car car;

    @BeforeEach
    void init() {
        car = Car.from("pobi");
    }

    @Test
    void 한_자동차_플레이_전진() {
        assertThat(Round.canMove(4)).isEqualTo(true);
    }

    @Test
    void 한_자동차_플레이_정지() {
        assertThat(Round.canMove(3)).isEqualTo(false);
    }

    @Test
    void 난수_생성() {
        assertThat(Round.draw())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
