package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    void 자동차_등록_개수_예외발생() {
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

        assertThatThrownBy(() -> racingGame.enrollCars(List.of("자동차명")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_등록_이름길이_예외발생() {
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

        assertThatThrownBy(() -> racingGame.enrollCars(List.of("자동차명여섯")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_등록_중복이름_예외발생() {
        RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

        assertThatThrownBy(() -> racingGame.enrollCars(List.of("자동차명", "자동차명")))
                .isInstanceOf(IllegalArgumentException.class);

    }
}