package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    @Test
    void 자동차_등록_개수_예외발생() {
        RacingCars racingCars = new RacingCars();

        assertThatThrownBy(() -> racingCars.addCars(List.of("자동차명")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_등록_이름길이_예외발생() {
        RacingCars racingCars = new RacingCars();

        assertThatThrownBy(() -> racingCars.addCars(List.of("자동차명여섯")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_등록_중복이름_예외발생() {
        RacingCars racingCars = new RacingCars();

        assertThatThrownBy(() -> racingCars.addCars(List.of("자동차명", "자동차명")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}