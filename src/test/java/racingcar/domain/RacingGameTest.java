package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class RacingGameTest {

    @Test
    void 우승자_한명를_반환한다() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);
        car1.move();

        Assertions.assertThat(racingGame.getWinners().size()).isEqualTo(1);
    }

    @Test
    void 우승자_두명를_반환한다() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);
        car1.move();
        car2.move();

        Assertions.assertThat(racingGame.getWinners().size()).isEqualTo(2);
    }

}