package racingcar.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.round.Result;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Car car;
    @BeforeEach
    void init() {
        car = Car.from("pobi");
        car.move();
    }

    @Test
    void 한_라운드_한_자동차_결과() {
        assertThat(Result.resultOf(car)).isEqualTo("pobi : -");
    }
}
